package com.example.sis.service;

import com.example.sis.entity.Student;
import com.example.sis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getAllStudents() { return studentRepository.findAll(); }
    public Student addStudent(Student student) { return studentRepository.save(student); }
}
