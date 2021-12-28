package org.alvheim.sphinx.repositories;

import org.alvheim.sphinx.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
