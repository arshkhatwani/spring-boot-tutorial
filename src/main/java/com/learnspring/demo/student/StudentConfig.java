package com.learnspring.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student s1 = new Student("Arsh", "ak@example.com", LocalDate.of(2001, Month.FEBRUARY, 2), 22);

            Student s2 = new Student("Sparsh", "sk@example.com", LocalDate.of(2005, Month.SEPTEMBER, 16), 17);

            repository.saveAll(List.of(s1, s2));
        };
    }
}
