package org.alvheim.sphinx.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "educator")
public class Educator {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name")
  @Size(max = 255)
  @NotBlank
  private String firstName;

  @Column(name = "middle_name")
  @Size(max = 255)
  private String middleName;

  @Column(name = "last_name")
  @Size(max = 255)
  @NotBlank
  private String lastName;

  @Column(name = "type")
  @NotBlank
// TODO protection
  private String type;

  @Column(name = "email", unique = true)
  @Email
  @NotBlank
  private String email;
}
