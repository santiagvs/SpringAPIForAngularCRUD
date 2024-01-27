package com.springapp.angularspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springapp.angularspring.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
