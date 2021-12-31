package org.alvheim.sphinx.controllers;

import java.util.Map;
import org.alvheim.sphinx.entities.Resource;
import org.alvheim.sphinx.services.ResourceService;
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
@RequestMapping("/resources")
public class ResourceController {

  private final ResourceService resourceService;

  public ResourceController(ResourceService resourceService) {
    this.resourceService = resourceService;
  }

  @PostMapping
  public ResponseEntity<Resource> save(@RequestBody Resource newResource) {
    return new ResponseEntity<>(resourceService.save(newResource), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Resource> replace(@RequestBody Resource newResource, @PathVariable Long id) {
    return new ResponseEntity<>(resourceService.replace(newResource, id), HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Resource> replacePartially(@RequestBody Map<String, Object> partialUpdates, @PathVariable Long id) {
    return new ResponseEntity<>(resourceService.partialReplace(partialUpdates, id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    resourceService.delete(id);
    return ResponseEntity.ok().build();
  }

}
