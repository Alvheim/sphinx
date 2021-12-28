package org.alvheim.sphinx.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "course_tree_structure")
public class CourseTreeStructure {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Long treeId;

  // Don`t really know what kind of relationship to use :(
  @Column(name = "course_id")
  private Long courseId;

  // Don`t really know what kind of relationship to use :(
  @Column(name = "next_course_id")
  private Long nextCourseId;
}
