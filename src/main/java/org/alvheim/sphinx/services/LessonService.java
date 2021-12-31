package org.alvheim.sphinx.services;

import java.util.Map;
import org.alvheim.sphinx.entities.Lesson;

public interface ResourceService {
  Lesson save(Lesson lesson);

  Lesson replace(Lesson newLesson, Long id);

  Lesson partialReplace(Map<String, Object> partialUpdates, Long id);

  void delete(Long id);
}
