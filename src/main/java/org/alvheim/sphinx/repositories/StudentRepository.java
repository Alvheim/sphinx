package org.alvheim.sphinx.repositories;

import org.alvheim.sphinx.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
