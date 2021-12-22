package org.alvheim.sphinx.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class LessonStageDTO {

  @NotNull
  private Long id;

  private int stage;

  @Size(max = 1024)
  private String stageComment;

  private Long lessonId;

}
