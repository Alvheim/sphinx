package org.alvheim.sphinx.services;

import java.util.Map;
import org.alvheim.sphinx.entities.User;

public interface UserService {

  User save(User newUser);

  User replace(User newUser, Long id);

  User partialReplace(Map<String, Object> partialUpdates, Long id);

  void delete(Long id);
}
