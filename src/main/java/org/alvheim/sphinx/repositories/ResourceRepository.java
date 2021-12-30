package org.alvheim.sphinx.repositories;

import org.alvheim.sphinx.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
