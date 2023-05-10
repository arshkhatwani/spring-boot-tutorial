package com.learnspring.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// <Student, Long> => <type of object, type of id>

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
