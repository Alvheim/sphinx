package org.alvheim.sphinx.entities;


import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "resource")
public class Resource {

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

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User author;

  @Column(name = "form")
  private int form;

  @Enumerated(EnumType.STRING)
  @Column(name = "work_mode")
  private WorkMode workMode;

  @Column(name = "scope_of_work_measure")
  private String scopeOfWorkMeasure;

  @Column(name = "scope_of_work_value")
  private int scopeOfWorkValue;

  @Column(name = "link")
  private String link;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Resource resource = (Resource) o;
    return id != null && Objects.equals(id, resource.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
