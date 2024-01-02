package com.example.testing.demo.repository;

import com.example.testing.demo.entity.Student;
import com.example.testing.demo.entity.StudentMarks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentMarksRepository extends JpaRepository<StudentMarks, Integer> {

    public List<Student> findByStudentId(Integer student_id);

    @Transactional
    public void deletebyStudentId(Integer studentId);
}
