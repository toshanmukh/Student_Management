package com.example.testing.demo.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private Integer student_id;

    @Column(name="student_name")
    private String student_name;

    @Column(name="student_class")
    private Integer student_class;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<StudentMarks> studentMarks = new HashSet<>();

    public Student(int id,String name, int student_class){
        this.student_id=id;
        this.student_name=name;
        this.student_class=student_class;
    }

    public Student() {

    }

    public void setStudent_id(Integer student_id){
        this.student_id=student_id;
    }
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

    public Set<StudentMarks> getStudentMarks() {
        return studentMarks;
    }
}
