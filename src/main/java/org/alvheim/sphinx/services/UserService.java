package org.alvheim.sphinx.services;

import java.util.List;
import org.alvheim.sphinx.entities.User;
import org.alvheim.sphinx.repositories.UserRepository;
import org.springframework.stereotype.Service;

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
}
