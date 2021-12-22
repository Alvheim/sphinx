package org.alvheim.sphinx.services.impl;

import org.alvheim.sphinx.repositories.LessonRepository;
import org.alvheim.sphinx.services.LessonService;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {

  private final LessonRepository lessonRepository;

  public LessonServiceImpl(LessonRepository lessonRepository) {
    this.lessonRepository = lessonRepository;
  }

}
