package org.alvheim.sphinx.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {

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

  @Column(name = "username", unique = true)
  @Size(max = 255)
  @NotBlank
  private String username;

//  @Column(name = "birthday")
//  private LocalDate birthday;

  @Column(name = "mobile_number", unique = true)
  @NotBlank
  private String mobileNumber;

  @Column(name = "additional_mobile_number", unique = true)
  private String additionalMobileNumber;

}
