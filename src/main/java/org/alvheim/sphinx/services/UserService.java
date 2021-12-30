package org.alvheim.sphinx.services;

import java.util.Map;
import org.alvheim.sphinx.entities.User;

public interface UserService {

  public User save(User newUser);

  public User replace(User newUser, Long id);


  public User partialReplace(Map<String, Object> partialUpdates, Long id);


}
