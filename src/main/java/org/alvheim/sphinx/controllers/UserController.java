package org.alvheim.sphinx.controllers;

import java.util.List;
import org.alvheim.sphinx.entities.User;
import org.alvheim.sphinx.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<User> save(@RequestBody User newUser) {
    return new ResponseEntity<>(userService.save(newUser), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> replace(@RequestBody User newUser, @PathVariable Long id) {
    return new ResponseEntity<>(userService.replace(newUser, id), HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<User> replacePartially(@RequestBody User newUser, @PathVariable Long id) {
    return new ResponseEntity<>(userService.replacePartially(newUser, id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    userService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
