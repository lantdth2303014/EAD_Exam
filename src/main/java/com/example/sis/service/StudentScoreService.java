package com.example.sis.service;

import com.example.sis.entity.StudentScore;
import com.example.sis.repository.StudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// The repository provides basic CRUD, but services allow extra logic like validation, logging, transactions.
// Service makes the code cleaner and easier to maintain by separating business logic from the database layer.
@Service
public class StudentScoreService {
    @Autowired // automatically provides an instance of StudentScoreRepository when StudentScoreService is created
    private StudentScoreRepository studentScoreRepository;

    public StudentScore addScore(StudentScore studentScore) { return studentScoreRepository.save(studentScore); }
}

// Old way:
// public class StudentScoreService {
//    private StudentScoreRepository studentScoreRepository;
//
//    public StudentScoreService() {
//        this.studentScoreRepository = new StudentScoreRepository(); // Manually creating the instance
//    }
//
//    public StudentScore addScore(StudentScore studentScore) {
//        return studentScoreRepository.save(studentScore);
//    }
// }