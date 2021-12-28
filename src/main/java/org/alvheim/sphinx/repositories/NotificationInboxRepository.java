package org.alvheim.sphinx.repositories;

import org.alvheim.sphinx.entities.NotificationInbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationInboxRepository extends JpaRepository<NotificationInbox, Long> {

}
