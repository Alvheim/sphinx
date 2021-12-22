package org.alvheim.sphinx.repositories;

import org.alvheim.sphinx.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
