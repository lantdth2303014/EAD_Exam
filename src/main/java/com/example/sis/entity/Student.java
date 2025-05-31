package com.example.sis.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference; // Require dependency: Spring Boot Web (REST API)
import jakarta.persistence.*; // For "@Entity" & "@Table"
import lombok.Getter;
import lombok.Setter;

import java.util.List; // For List<StudentScore>


@Getter
@Setter
@Entity
@Table(name = "student_t")
public class Student {
    // student_id (student_t's id)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    // student_code (true student id)
    @Column(name = "student_code", nullable = false)
    private String studentCode;

    // fullname
    @Column(name = "full_name", nullable = false)
    private String fullName;

    // @Column(name = "address", nullable = true): Redundant default parameter value assignment
    private String address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Bidirectional Student -> StudentScore
    private List<StudentScore> scores;
}
