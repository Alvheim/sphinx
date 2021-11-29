package org.alvheim.sphinx.services;

import java.util.List;
import org.alvheim.sphinx.entities.Source;
import org.alvheim.sphinx.repositories.SourceRepository;
import org.springframework.stereotype.Service;

@Service
public class SourceService {

  private final SourceRepository sourceRepository;

  public SourceService(SourceRepository sourceRepository) {
    this.sourceRepository = sourceRepository;
  }

  public List<Source> getSources() {
    return sourceRepository.findAll();
  }

  public Source addSource(Source source) {
    return sourceRepository.save(source);
  }
}
