package com.learnspring.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

// <Student, Long> => <type of object, type of id>

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Modifying
    @Query("UPDATE Student s SET s.email = ?1, s.name = ?2 WHERE s.id = ?3")
    void updateStudentNameEmail(String email, String name, Long id);
}
