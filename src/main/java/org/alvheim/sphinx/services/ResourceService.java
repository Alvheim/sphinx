package org.alvheim.sphinx.services;

import java.util.List;
import org.alvheim.sphinx.entities.Resource;

public interface ResourceService {

  public List<Resource> getResources();

  public Resource addResource(Resource resource);

}
