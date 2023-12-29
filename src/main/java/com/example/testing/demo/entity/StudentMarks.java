package com.example.testing.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="marks")
public class StudentMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="marks_id")
    private Integer marks_id;

    @Column(name="subject", nullable = false)
    private String subject;

    @Column(name="marks", nullable = false)
    private Integer marks;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public Student getStudent() {
        return student;
    }

    public Integer getMarks() {
        return marks;
    }
}
