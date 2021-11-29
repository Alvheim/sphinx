package org.alvheim.sphinx.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name = "educator")
public class Educator {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "type", nullable = false)
// TODO protection (what protection, CARL?)
  private String type;

  @Column(name = "email", unique = true, nullable = false)
  @Email
  private String email;
}
