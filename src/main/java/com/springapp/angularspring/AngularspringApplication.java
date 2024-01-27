package com.springapp.angularspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springapp.angularspring.model.Course;
import com.springapp.angularspring.repository.CourseRepository;

@SpringBootApplication
public class AngularspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularspringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();
			courseRepository.save(Course.builder().name("Java").category("Programming").build());
			courseRepository.save(Course.builder().name("Spring").category("Framework").build());
			courseRepository.save(Course.builder().name("Angular").category("Framework").build());
		};
	}

}
