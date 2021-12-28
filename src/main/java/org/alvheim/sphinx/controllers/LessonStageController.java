package org.alvheim.sphinx.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.alvheim.sphinx.dto.LessonStageDTO;
import org.alvheim.sphinx.entities.LessonStage;
import org.alvheim.sphinx.services.LessonStageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson-stage")
public class LessonStageController {

  private final ObjectMapper objectMapper;
  private final LessonStageService lessonStageService;

  public LessonStageController(ObjectMapper objectMapper,
      LessonStageService lessonStageService) {
    this.objectMapper = objectMapper;
    this.lessonStageService = lessonStageService;
  }

  @PostMapping
  public ResponseEntity<?> save(LessonStageDTO lessonStageDTO) {
    LessonStage lessonStage = objectMapper.convertValue(lessonStageDTO, LessonStage.class);
    lessonStageService.save(lessonStage);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/{lessonId}")
  public ResponseEntity<List<LessonStageDTO>> getLessonStagesByLessonId(@PathVariable Long lessonId) {
    return new ResponseEntity<>(objectMapper.convertValue(
        lessonStageService.getLessonStagesByLessonId(lessonId), new TypeReference<List<LessonStageDTO>>() {}
    ), HttpStatus.OK);
  }

}
