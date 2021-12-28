package org.alvheim.sphinx.repositories;

import org.alvheim.sphinx.entities.MessagePattern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagePatternRepository extends JpaRepository<MessagePattern, Long> {

}
