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
@Table(name = "source")
public class Source {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "branch")
  private int branch;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "form")
  private int form;

  @Column(name = "work_mode")
  private WorkMode workMode;

  @Column(name = "scope_of_work_measure")
  private String scopeOfWorkMeasure;

  @Column(name = "scope_of_work_value")
  private int scopeOfWorkValue;

  @Column(name = "comments")
  private String comments;

}
