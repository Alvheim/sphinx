package org.alvheim.sphinx.services.impl;

import org.alvheim.sphinx.repositories.UserInWorkRepository;
import org.alvheim.sphinx.services.UserInWorkService;
import org.springframework.stereotype.Service;

@Service
public class UserInWorkServiceImpl implements UserInWorkService {

  private final UserInWorkRepository userInWorkRepository;

  public UserInWorkServiceImpl(
      UserInWorkRepository userInWorkRepository) {
    this.userInWorkRepository = userInWorkRepository;
  }
}