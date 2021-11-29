package org.alvheim.sphinx.controllers;

import java.util.List;
import org.alvheim.sphinx.entities.Student;
import org.alvheim.sphinx.repositories.StudentRepository;
import org.alvheim.sphinx.services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> findAll() {
    return studentService.getStudents();
  }

  @PostMapping
  public Student save(@RequestBody Student newStudent) {
    return studentService.addStudent(newStudent);
  }
}
