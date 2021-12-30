package org.alvheim.sphinx.services.impl;

import org.alvheim.sphinx.repositories.MessagePatternRepository;
import org.alvheim.sphinx.services.MessagePatternService;
import org.springframework.stereotype.Service;

@Service
public class MessagePatternServiceImpl implements MessagePatternService {

  private final MessagePatternRepository messagePatternRepository;

  public MessagePatternServiceImpl(
      MessagePatternRepository messagePatternRepository) {
    this.messagePatternRepository = messagePatternRepository;
  }
}
