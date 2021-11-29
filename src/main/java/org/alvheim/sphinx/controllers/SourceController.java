package org.alvheim.sphinx.controllers;

import java.util.List;
import org.alvheim.sphinx.entities.Source;
import org.alvheim.sphinx.services.SourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sources")
public class SourceController {

  private final SourceService sourceService;

  public SourceController(SourceService sourceService) {
    this.sourceService = sourceService;
  }

  @GetMapping
  public List<Source> findAll() {
    return sourceService.getSources();
  }

  @PostMapping
  public Source save(@RequestBody Source source) {
    return sourceService.addSource(source);
  }

}
