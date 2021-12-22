package org.alvheim.sphinx.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
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
@Table(name = "lesson")
public class Lesson {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "goal")
  private String goal;

  @Column(name = "stage_count")
  private int stageCount;

  @Column(name = "general_required_time")
  private long generalTimeToPassInSeconds;

  @OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY)
  private Set<CourseStructure> lessonStructures;

  @OneToMany(mappedBy = "lesson")
  private Set<LessonStage> lessonStages = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Lesson lesson = (Lesson) o;
    return id != null && Objects.equals(id, lesson.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
