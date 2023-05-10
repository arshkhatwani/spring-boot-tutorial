package com.learnspring.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1.0/student")
public class StudentController {

	@GetMapping
	public List<Student> getStudents() {
		Student s1 = Student.builder().id(1L).name("Arsh").email("ak@example.com").age(22)
				.dob(LocalDate.of(2001, Month.FEBRUARY, 2)).build();

		Student s2 = Student.builder().id(2L).name("Sparsh").email("sk@example.com").age(17)
				.dob(LocalDate.of(2005, Month.SEPTEMBER, 16)).build();

		return List.of(s1, s2);
	}
}
