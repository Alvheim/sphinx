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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "course")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "lesson_count")
  private int lessonCount;

  @Column(name = "general_required_time")
  private long generalTimeToPassInSeconds;

  @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
  private Set<User> users = new HashSet<>();

  @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
  private Set<CourseStructure> courseStructures;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Course course = (Course) o;
    return lessonCount == course.lessonCount
        && generalTimeToPassInSeconds == course.generalTimeToPassInSeconds
        && Objects.equals(id, course.id) && Objects.equals(title, course.title)
        && Objects.equals(description, course.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, lessonCount, generalTimeToPassInSeconds);
  }
}
