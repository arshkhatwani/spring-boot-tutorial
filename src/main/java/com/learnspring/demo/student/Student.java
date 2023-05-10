package com.learnspring.demo.student;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Student {
    @Getter @Setter private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String email;
    @Getter @Setter private LocalDate dob;
    @Getter @Setter private Integer age;
}
