package com.example.sis.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student_score_t")
public class StudentScore {
    // student_score_id (PRIMARY KEY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentScoreId;

    // student_id (FOREIGN KEY)
    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference // prevent infinite recursion (Bidirectional StudentScore -> Student)
    private Student student;

    // subject_id (FOREIGN KEY)
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    // "double" value
    private double score1;
    private double score2;

    // getGrade function
    public String getGrade() {
        double grade = (0.3 * score1) + (0.7 * score2);
        if (grade >= 8.0) return "A";   // each "if" is mutually exclusive
        if (grade >= 7.0) return "B";   // when an "if" condition is true, the function returns and stops
        if (grade >= 6.0) return "C";   // so "else if" is redundant here
        if (grade >= 4.0) return "D";
        return "F";
    }
}
