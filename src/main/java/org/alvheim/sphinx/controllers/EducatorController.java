package org.alvheim.sphinx.controllers;

import java.util.List;
import org.alvheim.sphinx.entities.Educator;
import org.alvheim.sphinx.services.EducatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educators")
public class EducatorController {

  private final EducatorService educatorService;

  public EducatorController(EducatorService educatorService) {
    this.educatorService = educatorService;
  }

  @GetMapping
  public List<Educator> findAll() {
    return educatorService.getEducators();
  }

  @PostMapping
  public Educator save(@RequestBody Educator newEducator){
    return educatorService.addEducator(newEducator);
  }

}
