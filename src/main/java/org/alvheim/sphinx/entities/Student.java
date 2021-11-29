package org.alvheim.sphinx.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {

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

  @Column(name = "username", unique = true, nullable = false)
  private String username;

//  @Column(name = "birthday")
//  private LocalDate birthday;

  @Column(name = "mobile_number", unique = true, nullable = false)
  private String mobileNumber;

  @Column(name = "additional_mobile_number", unique = true)
  private String additionalMobileNumber;

}
