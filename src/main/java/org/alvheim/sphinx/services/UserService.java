package org.alvheim.sphinx.services;

import java.time.LocalDate;
import java.util.List;
import org.alvheim.sphinx.entities.User;
import org.alvheim.sphinx.exception.ResourceNotFoundException;
import org.alvheim.sphinx.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User save(User newUser) {
    return userRepository.save(newUser);
  }

  @Transactional
  public User replace(User newUser, Long id) {
    return userRepository
        .findById(id)
        .map(
            user -> {
              user.setFirstName(newUser.getFirstName());
              user.setLastName(newUser.getLastName());
              user.setMiddleName(newUser.getMiddleName());
              user.setEmail(newUser.getEmail());
              user.setPassword(newUser.getPassword());
              user.setBirthday(newUser.getBirthday());
              user.setMobileNumber(newUser.getMobileNumber());
              user.setAdditionalMobileNumber(newUser.getAdditionalMobileNumber());
              return user;
            })
        .orElseThrow(() -> new ResourceNotFoundException("No user with id: " + id + " was found"));
  }

  @Transactional
  public User replacePartially(User newUser, Long id) {
    User userToUpdate = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No user with id: " + id + " was found"));
    String firstName = newUser.getFirstName();
    String middleName = newUser.getMiddleName();
    String lastName = newUser.getLastName();
    String email = newUser.getEmail();
    String password = newUser.getPassword();
    LocalDate birthday = newUser.getBirthday();
    String mobileNumber = newUser.getMobileNumber();
    String additionalMobileNumber = newUser.getAdditionalMobileNumber();
    if (firstName != null && !firstName.isEmpty()) {
      userToUpdate.setFirstName(firstName);
    }
    if (lastName != null && !lastName.isEmpty()) {
      userToUpdate.setLastName(lastName);
    }
    if (email != null && !email.isEmpty()) {
      userToUpdate.setEmail(email);
    }
    if (password != null && !password.isEmpty()) {
      userToUpdate.setPassword(password);
    }
    if (middleName != null && !middleName.isEmpty()) {
      userToUpdate.setMiddleName(middleName);
    }
    if (birthday != null) {
      userToUpdate.setBirthday(birthday);
    }
    if (mobileNumber != null && !mobileNumber.isEmpty()) {
      userToUpdate.setMobileNumber(mobileNumber);
    }
    if (additionalMobileNumber != null && !additionalMobileNumber.isEmpty()) {
      userToUpdate.setAdditionalMobileNumber(additionalMobileNumber);
    }
    return userToUpdate;
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}
