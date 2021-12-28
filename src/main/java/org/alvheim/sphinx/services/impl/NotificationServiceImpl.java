package org.alvheim.sphinx.services.impl;

import org.alvheim.sphinx.repositories.NotificationRepository;
import org.alvheim.sphinx.services.NotificationService;

public class NotificationServiceImpl implements NotificationService {
  private final NotificationRepository notificationRepository;

  public NotificationServiceImpl(NotificationRepository notificationRepository) {
    this.notificationRepository = notificationRepository;
  }

}
