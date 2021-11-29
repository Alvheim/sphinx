package org.alvheim.sphinx.services;

import java.util.List;
import org.alvheim.sphinx.entities.Educator;
import org.alvheim.sphinx.repositories.EducatorRepository;
import org.springframework.stereotype.Service;

@Service
public class EducatorService {

  private final EducatorRepository educatorRepository;

  public EducatorService(EducatorRepository educatorRepository) {
    this.educatorRepository = educatorRepository;
  }

  public List<Educator> getEducators() {
    return educatorRepository.findAll();
  }

  public Educator addEducator(Educator newEducator) {
    return educatorRepository.save(newEducator);
  }

}
