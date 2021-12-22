package org.alvheim.sphinx.repositories;

import org.alvheim.sphinx.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
