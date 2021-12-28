package org.alvheim.sphinx.controllers;

import java.util.Map;
import org.alvheim.sphinx.entities.User;
import org.alvheim.sphinx.services.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserServiceImpl userServiceImpl;

  public UserController(UserServiceImpl userServiceImpl) {
    this.userServiceImpl = userServiceImpl;
  }

  @PostMapping
  public ResponseEntity<User> save(@RequestBody User newUser) {
    return new ResponseEntity<>(userServiceImpl.save(newUser), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> replace(@RequestBody User newUser, @PathVariable Long id) {
    return new ResponseEntity<>(userServiceImpl.replace(newUser, id), HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<User> replacePartially(@RequestBody Map<String, Object> update, @PathVariable Long id) {
    return new ResponseEntity<>(userServiceImpl.partialReplace(update, id), HttpStatus.OK);
  }

}
