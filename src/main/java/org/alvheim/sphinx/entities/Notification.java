package org.alvheim.sphinx.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "notification")
public class Notification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "notification_id", unique = true)
  private Long notificationID;

  @Column(name = "user_id", nullable = false)
  private Long userID;

  @Column(name = "channel", nullable = false)
  private String channel;

  @Column(name = "message", nullable = false)
  private String message;

  @Column(name = "time_for_sending", nullable = false)
  private LocalDate timeForSending;

  @Column(name = "status", nullable = false)
  private String status;
}
