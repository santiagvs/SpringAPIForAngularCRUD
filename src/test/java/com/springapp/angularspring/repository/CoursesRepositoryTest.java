package com.springapp.angularspring.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.springapp.angularspring.model.Course;

import jakarta.transaction.Transactional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE, connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles("test")
public class CoursesRepositoryTest {

  @Autowired
  private CourseRepository courseRepository;

  private Course course;

  @BeforeEach
  public void setup() {
    course = Course.builder().name("Ruby").category("Back-End").build();
  }

  @Test
  @Transactional
  public void CourseRepository_FindAll_ReturnsListOfCourses() {
    Course course2 = Course.builder().name("React").category("Front-End").build();
    courseRepository.saveAll(List.of(course, course2));

    Iterable<Course> courses = courseRepository.findAll();

    Assertions.assertThat(courses).isNotEmpty();
    Assertions.assertThat(courses).hasSize(2);
    Assertions.assertThat(courses).element(0).hasFieldOrPropertyWithValue("category", "Back-End");
  }

  @Test
  @Transactional
  public void CourseRepository_Save_ReturnsSavedCourse() {
    Course savedCourse = courseRepository.save(course);

    Assertions.assertThat(savedCourse).isNotNull();
    Assertions.assertThat(savedCourse).hasFieldOrPropertyWithValue("name", "Ruby");
    Assertions.assertThat(savedCourse).hasFieldOrPropertyWithValue("category", "Back-End");
  }

  @Test
  @Transactional
  public void CourseRepository_FindById_ReturnsCourse() {
    Course savedCourse = courseRepository.save(course);

    Course foundCourse = courseRepository.findById(savedCourse.getId()).get();

    Assertions.assertThat(foundCourse).isNotNull();
    Assertions.assertThat(foundCourse).hasFieldOrPropertyWithValue("name", "Ruby");
    Assertions.assertThat(foundCourse).hasFieldOrPropertyWithValue("category", "Back-End");
  }

  @Test
  @Transactional
  public void CourseRepository_DeleteById_ReturnsNothing() {
    Course savedCourse = courseRepository.save(course);

    courseRepository.deleteById(savedCourse.getId());

    Assertions.assertThat(courseRepository.findById(savedCourse.getId())).isEmpty();
  }
}
