package org.alvheim.sphinx.repositories;

import org.alvheim.sphinx.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
