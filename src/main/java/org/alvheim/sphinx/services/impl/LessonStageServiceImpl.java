package org.alvheim.sphinx.services.impl;

import static org.alvheim.sphinx.services.util.ServiceUtils.applyPatches;

import java.util.List;
import java.util.Map;
import org.alvheim.sphinx.entities.LessonStage;
import org.alvheim.sphinx.exception.ResourceNotFoundException;
import org.alvheim.sphinx.repositories.LessonStageRepository;
import org.alvheim.sphinx.services.LessonStageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LessonStageServiceImpl implements LessonStageService {

  private final LessonStageRepository lessonStageRepository;

  public LessonStageServiceImpl(
      LessonStageRepository lessonStageRepository) {
    this.lessonStageRepository = lessonStageRepository;
  }

  @Override
  public void save(LessonStage lessonStage) {
    lessonStageRepository.save(lessonStage);
  }

  @Override
  public List<LessonStage> getLessonStagesByLessonId(Long lessonId) {
    return lessonStageRepository.findLessonStageByLessonId(lessonId);
  }

  @Override
  public void delete(Long lessonStageId) {
    lessonStageRepository.deleteById(lessonStageId);
  }

  @Transactional
  @Override
  public void replace(LessonStage newLessonStage, Long id) {
    lessonStageRepository
        .findById(id)
        .ifPresentOrElse(lessonStage -> {
          lessonStage.setStage(newLessonStage.getStage());
          lessonStage.setStageComment(newLessonStage.getStageComment());
        }, () -> {
          throw new ResourceNotFoundException("No lesson stage with id: " + id + " was found");
        });
  }

  @Transactional
  @Override
  public void partialReplace(Map<String, Object> partialUpdates, Long id) {
    LessonStage lessonStageToPatch =
        lessonStageRepository
            .findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("No lesson stage with id: " + id + " was found"));

    applyPatches(lessonStageToPatch, partialUpdates, LessonStage.class);
  }
}
