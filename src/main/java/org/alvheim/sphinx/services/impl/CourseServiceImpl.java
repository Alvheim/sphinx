package org.alvheim.sphinx.services.impl;

import org.alvheim.sphinx.repositories.CourseRepository;
import org.alvheim.sphinx.services.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;

  public CourseServiceImpl(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }
}
