package org.alvheim.sphinx.services;

import java.util.List;
import java.util.Map;
import org.alvheim.sphinx.entities.LessonStage;

public interface LessonStageService {

  void save(LessonStage lessonStage);

  List<LessonStage> getLessonStagesByLessonId(Long lessonId);

  void delete(Long lessonStageId);

  void replace(LessonStage lessonStage, Long id);

  void partialReplace(Map<String, Object> partialUpdates, Long id);
}
