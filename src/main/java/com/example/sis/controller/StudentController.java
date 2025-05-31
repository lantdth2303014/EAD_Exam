package com.example.sis.controller;

import com.example.sis.entity.StudentScore;
import com.example.sis.entity.Student;
import com.example.sis.service.StudentScoreService;
import com.example.sis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // For "@RestContrller" & "@RequestMapping"

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    // Call services:
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentScoreService studentScoreService;

    @GetMapping // GET API: get all students
    public List<Student> getAllStudents() { return studentService.getAllStudents(); }

    @PostMapping // POST API: add a student
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @PostMapping("/score") // POST API: add score to a student
    public ResponseEntity<StudentScore> addScore(@RequestBody StudentScore studentScore) {
        return ResponseEntity.ok(studentScoreService.addScore(studentScore));
    }

    // Flow:
    // 1. Client sends a POST request with JSON body:
    // 2. Spring converts JSON → Java object (StudentScore)
    // 3. Controller calls studentScoreService.addScore(studentScore)
    // 4. Service saves scores to the database
    // 5. Returns ResponseEntity.ok(student) (default for 200:OK)
}
