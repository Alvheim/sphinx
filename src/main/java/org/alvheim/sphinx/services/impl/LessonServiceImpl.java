package org.alvheim.sphinx.services.impl;

import static org.alvheim.sphinx.services.util.ServiceUtils.applyPatches;

import java.util.Map;
import javax.transaction.Transactional;
import org.alvheim.sphinx.entities.Lesson;
import org.alvheim.sphinx.exception.ResourceNotFoundException;
import org.alvheim.sphinx.repositories.LessonRepository;
import org.alvheim.sphinx.services.LessonService;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {

  private final LessonRepository lessonRepository;

  public LessonServiceImpl(LessonRepository lessonRepository) {
    this.lessonRepository = lessonRepository;
  }

  @Override
  public Lesson save(Lesson lesson) {
    return lessonRepository.save(lesson);
  }

  @Transactional
  @Override
  public Lesson replace(Lesson newLesson, Long id) {
    return lessonRepository
        .findById(id)
        .map(
            lesson -> {
              lesson.setTitle(newLesson.getTitle());
              lesson.setGoal(newLesson.getGoal());
              lesson.setStageCount(newLesson.getStageCount());
              lesson.setGeneralTimeToPassInSeconds(newLesson.getGeneralTimeToPassInSeconds());
              return lesson;
            })
        .orElseThrow(() -> new ResourceNotFoundException("No lesson with id: " + id + " was found"));
  }

  @Transactional
  @Override
  public Lesson partialReplace(Map<String, Object> partialUpdates, Long id) {
    Lesson lessonToPatch =
        lessonRepository
            .findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("No lesson with id: " + id + " was found"));

    return applyPatches(lessonToPatch, partialUpdates, Lesson.class);
  }

  @Override
  public void delete(Long id) {
    lessonRepository.deleteById(id);
  }
}
