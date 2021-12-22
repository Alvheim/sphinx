package org.alvheim.sphinx.services.impl;

import static org.alvheim.sphinx.services.util.ServiceUtils.applyPatches;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.alvheim.sphinx.entities.User;
import org.alvheim.sphinx.exception.ResourceNotFoundException;
import org.alvheim.sphinx.repositories.UserRepository;
import org.alvheim.sphinx.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User save(User newUser) {
    return userRepository.save(newUser);
  }

  @Transactional
  @Override
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
  @Override
  public User partialReplace(Map<String, Object> partialUpdates, Long id) {
    User userToPatch =
        userRepository
            .findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("No user with id: " + id + " was found"));

    return applyPatches(userToPatch, partialUpdates, User.class);
  }
}
