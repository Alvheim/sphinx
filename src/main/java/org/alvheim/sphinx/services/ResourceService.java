package org.alvheim.sphinx.services;

import java.util.List;
import java.util.Map;
import org.alvheim.sphinx.entities.Resource;

public interface ResourceService {

  List<Resource> findAll();

  Resource save(Resource newResource);

  Resource replace(Resource newResource, Long id);

  Resource partialReplace(Map<String, Object> partialUpdates, Long id);

  void delete(Long id);
}
