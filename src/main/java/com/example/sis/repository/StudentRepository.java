package com.example.sis.repository;

import com.example.sis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// In Spring Data JPA, a repository is used to interact with the database.
// It provides built-in methods for CRUD operations (Create, Read, Update, Delete)
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> { // automatically provides methods like save(), findById(), delete()
    Optional<Student> findByStudentCode(String studentCode); // If the student doesn’t exist, it returns Optional.empty(), avoiding NullPointerException
}