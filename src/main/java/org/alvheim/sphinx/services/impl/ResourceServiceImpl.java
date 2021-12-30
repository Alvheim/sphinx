package org.alvheim.sphinx.services.impl;

import java.util.List;
import org.alvheim.sphinx.entities.Resource;
import org.alvheim.sphinx.repositories.ResourceRepository;
import org.alvheim.sphinx.services.ResourceService;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

  private final ResourceRepository resourceRepository;

  public ResourceServiceImpl(ResourceRepository resourceRepository) {
    this.resourceRepository = resourceRepository;
  }

  @Override
  public List<Resource> getResources() {
    return resourceRepository.findAll();
  }

  @Override
  public Resource addResource(Resource resource) {
    return resourceRepository.save(resource);
  }
}
