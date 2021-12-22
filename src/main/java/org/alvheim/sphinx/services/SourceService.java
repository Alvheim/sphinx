package org.alvheim.sphinx.services;

import java.util.List;
import org.alvheim.sphinx.entities.Resource;
import org.alvheim.sphinx.repositories.SourceRepository;
import org.springframework.stereotype.Service;

@Service
public class SourceService {

  private final SourceRepository sourceRepository;

  public SourceService(SourceRepository sourceRepository) {
    this.sourceRepository = sourceRepository;
  }

  public List<Resource> getSources() {
    return sourceRepository.findAll();
  }

  public Resource addSource(Resource resource) {
    return sourceRepository.save(resource);
  }
}
