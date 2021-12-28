package org.alvheim.sphinx.dto;

import lombok.Data;

@Data
public class LessonStageDTO {

  private Long id;

  private int stage;

  private String stageComment;

  private Long lessonId;

}
