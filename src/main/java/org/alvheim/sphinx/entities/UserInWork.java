package org.alvheim.sphinx.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "user_in_work")
public class UserInWork {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "task_type")
  private ApprovedStatus taskType;

  //  TODO: kind of relationship
//  @Column(name = "task_id")
//  private Task taskId;

  //  TODO: kind of relationship
  @Column(name = "user_id")
  private User user;

  @Column(name = "id_done")
  private Boolean isDone;
}
