package com.learnspring.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnspring.demo.student.Student;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public List<Student> hello() {
		Student s1 = Student.builder().id(1L).name("Arsh").email("ak@example.com").age(22)
				.dob(LocalDate.of(2001, Month.FEBRUARY, 2)).build();

		Student s2 = Student.builder().id(2L).name("Sparsh").email("sk@example.com").age(17)
				.dob(LocalDate.of(2005, Month.SEPTEMBER, 16)).build();

		return List.of(s1, s2);
	}
}
