package com.learnspring.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        Boolean exists = studentRepository.existsById(studentId);

        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Boolean exists = studentRepository.existsById(studentId);
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);

        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        if (studentByEmail.isPresent() && studentByEmail.get().getId() != studentId) {
            throw new IllegalStateException("Student with email " + email + " already exists");
        }
        if (email == "" || name == "") {
            throw new IllegalStateException("Please enter non empty email / name");
        }

        studentRepository.updateStudentNameEmail(email, name, studentId);
    }
}
