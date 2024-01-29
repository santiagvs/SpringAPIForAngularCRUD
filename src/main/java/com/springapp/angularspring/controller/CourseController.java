package com.springapp.angularspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.angularspring.model.Course;
import com.springapp.angularspring.repository.CourseRepository;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

  private final CourseRepository courseRepository;

  @GetMapping
  public List<Course> list() {
    return courseRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Course create(@RequestBody Course course) {
    return courseRepository.save(course);
  }
}
