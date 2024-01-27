package com.springapp.angularspring.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
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

  @Test
  @Transactional
  public void CourseRepository_FindAll_ReturnsListOfCourses() {
    Course course = Course.builder().name("Ruby").category("Back-End").build();
    Course course2 = Course.builder().name("React").category("Front-End").build();
    courseRepository.saveAll(List.of(course, course2));

    Iterable<Course> courses = courseRepository.findAll();

    Assertions.assertThat(courses).isNotEmpty();
    Assertions.assertThat(courses).hasSize(2);
    Assertions.assertThat(courses).element(0).hasFieldOrPropertyWithValue("category", "Back-End");
  }
}
