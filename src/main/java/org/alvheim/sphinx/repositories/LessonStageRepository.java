package org.alvheim.sphinx.repositories;

import java.util.List;
import org.alvheim.sphinx.entities.LessonStage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonStageRepository extends JpaRepository<LessonStage, Long> {

  List<LessonStage> findLessonStageByLessonId(Long lessonId);

}
