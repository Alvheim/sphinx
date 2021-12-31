package org.alvheim.sphinx.controllers;

import java.util.Map;
import org.alvheim.sphinx.entities.Lesson;
import org.alvheim.sphinx.services.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lessons")
public class LessonController {

  private final LessonService lessonService;

  public LessonController(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @PostMapping
  public ResponseEntity<Lesson> save(@RequestBody Lesson newLesson) {
    return new ResponseEntity<>(lessonService.save(newLesson), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Lesson> replace(@RequestBody Lesson newLesson, @PathVariable Long id) {
    return new ResponseEntity<>(lessonService.replace(newLesson, id), HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Lesson> replacePartially(@RequestBody Map<String, Object> partialUpdates, @PathVariable Long id) {
    return new ResponseEntity<>(lessonService.partialReplace(partialUpdates, id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    lessonService.delete(id);
    return ResponseEntity.ok().build();
  }
}