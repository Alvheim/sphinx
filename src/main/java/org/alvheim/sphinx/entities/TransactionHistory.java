package org.alvheim.sphinx.entities;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "transaction_history")
public class TransactionHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "object_type")
  private ObjectType objectType;

//  TODO: object id
//  @ManyToOne
//  @JoinColumn(name = "object_id")

  @Column(name = "attribute_name")
  private String attributeName;

  @Column(name = "attribute_type")
  private String attributeType;

  @Column(name = "attribute_previous_value")
  private String attributePreviousValue;

  @Column(name = "attribute_new_value")
  private String attributeNewValue;

  @Column(name = "requested_time")
  private LocalDate requestedTime;

  @OneToOne
  @Column(name = "user_id")
  private User user;

  @Column(name = "user_comment")
  private String userComment;

  @Enumerated(EnumType.STRING)
  @Column(name = "approved_status")
  private ApprovedStatus approvedStatus;
}
