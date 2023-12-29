package com.example.testing.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue
    @Column(name="student_id")
    private Integer student_id;

    @Column(name="student_name")
    private String student_name;

    @Column(name="student_class")
    private Integer student_class;

    public Integer getStudent_id() {
        return student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public Integer getStudent_class() {
        return student_class;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_class(Integer student_class) {
        this.student_class = student_class;
    }
}
