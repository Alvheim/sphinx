package org.alvheim.sphinx.services.impl;

import org.alvheim.sphinx.repositories.NotificationInboxRepository;
import org.alvheim.sphinx.services.NotificationService;

public class NotificationInboxServiceImpl implements NotificationService {
  private final NotificationInboxRepository notificationInboxRepository;

  public NotificationInboxServiceImpl(NotificationInboxRepository notificationInboxRepository) {
    this.notificationInboxRepository = notificationInboxRepository;
  }
}
