package com.example.testing.demo.controller;

import com.example.testing.demo.Exceptions.StudentNotFoundException;
import com.example.testing.demo.entity.Student;
import com.example.testing.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/students/all")
    public List<Student> all(){
        return studentRepository.findAll();
    }
    @GetMapping(value = "/students/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
        }


    @PostMapping(value = "/students")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping(value = "/students/{id}")
    public Student updateStudent(@RequestBody Student newStudent, @PathVariable Integer id){
        return studentRepository.findById(id).map(student ->{
            student.setStudent_name(newStudent.getStudent_name());
            student.setStudent_class(newStudent.getStudent_class());
            return studentRepository.save(student);
        })
                .orElseGet(() -> {
                    newStudent.setStudent_id(id);
                    return studentRepository.save(newStudent);
                });
    }
    @DeleteMapping(value = "/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(Math.toIntExact(id));
    }
}
