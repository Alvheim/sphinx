package org.alvheim.sphinx.repositories;

import org.alvheim.sphinx.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Resource, Long> {

}
