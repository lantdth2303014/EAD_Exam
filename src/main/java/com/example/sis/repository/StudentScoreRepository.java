package com.example.sis.repository;

import com.example.sis.entity.Student;
import com.example.sis.entity.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentScoreRepository extends JpaRepository<StudentScore, Integer> {
    List<StudentScore> findByStudent(Student student); // retrieve all scores for a given student
}