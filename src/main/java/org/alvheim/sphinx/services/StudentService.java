package org.alvheim.sphinx.services;

import java.util.List;
import org.alvheim.sphinx.entities.Student;
import org.alvheim.sphinx.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public Student addStudent(Student newStudent) {
    return studentRepository.save(newStudent);
  }
}
