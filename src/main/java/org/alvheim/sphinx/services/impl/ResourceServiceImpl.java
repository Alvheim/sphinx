package org.alvheim.sphinx.services.impl;

import static org.alvheim.sphinx.services.util.ServiceUtils.applyPatches;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.alvheim.sphinx.entities.Resource;
import org.alvheim.sphinx.exception.ResourceNotFoundException;
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
  public List<Resource> findAll() {
    return resourceRepository.findAll();
  }

  @Override
  public Resource save(Resource newResource) {
    return resourceRepository.save(newResource);
  }

  @Transactional
  @Override
  public Resource replace(Resource newResource, Long id) {
    return resourceRepository
        .findById(id)
        .map(
            resource -> {
              resource.setBranch(newResource.getBranch());
              resource.setTitle(newResource.getTitle());
              resource.setDescription(newResource.getDescription());
              resource.setAuthor(newResource.getAuthor());
              resource.setForm(newResource.getForm());
              resource.setWorkMode(newResource.getWorkMode());
              resource.setScopeOfWorkMeasure(newResource.getScopeOfWorkMeasure());
              resource.setScopeOfWorkValue(newResource.getScopeOfWorkValue());
              resource.setLink(newResource.getLink());
              return resource;
            })
        .orElseThrow(
            () -> new ResourceNotFoundException("No resource with id: " + id + " was found"));
  }

  @Transactional
  @Override
  public Resource partialReplace(Map<String, Object> partialUpdates, Long id) {
    Resource resourceToPatch =
        resourceRepository
            .findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("No resource with id: " + id + " was found"));

    return applyPatches(resourceToPatch, partialUpdates, Resource.class);
  }

  @Override
  public void delete(Long id) {
    resourceRepository.deleteById(id);
  }
}
