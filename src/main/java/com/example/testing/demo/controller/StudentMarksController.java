package com.example.testing.demo.controller;

import com.example.testing.demo.Exceptions.StudentMarksNotFoundException;
import com.example.testing.demo.Exceptions.StudentNotFoundException;
import com.example.testing.demo.entity.Student;
import com.example.testing.demo.entity.StudentMarks;
import com.example.testing.demo.repository.StudentMarksRepository;
import com.example.testing.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class StudentMarksController {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMarksRepository studentMarksRepository;

    public StudentMarksController(StudentMarksRepository studentMarksRepository) {
        this.studentMarksRepository = studentMarksRepository;
    }

    @GetMapping("/students/{id}/marks")
    public List<Student> getAllMarksByStudentId(@PathVariable(value = "id") Integer id){
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException(id);
        }

        return studentMarksRepository.findByStudentId(id);

    }

    @PostMapping(value = "/students/{id}/marks")
    public StudentMarks createStudent(@PathVariable(value="id") Integer id,@RequestBody StudentMarks studentMarks) {
        return studentRepository.findById(id).map(student->{
            studentMarks.setStudent(student);
            return studentMarksRepository.save(studentMarks);
        }).orElseThrow(()-> new StudentNotFoundException(id));


    }

    @PutMapping(value="/students/{studentId}/marks/{marksId}")
    public StudentMarks updateStudentMarks(@PathVariable(value = "studentId") Integer studentId, @PathVariable(value = "marksId") Integer marksId, @RequestBody StudentMarks studentMarks){
        if(!studentRepository.existsById(studentId)){
            throw new StudentNotFoundException(studentId);
        }
        return studentMarksRepository.findById(marksId).map(mark ->{
            mark.setSubject(studentMarks.getSubject());
            mark.setMarks(studentMarks.getMarks());
            mark.setStudent(studentMarks.getStudent());
            return studentMarksRepository.save(mark);
        }).orElseThrow(()-> new StudentMarksNotFoundException(marksId));
    }

    @DeleteMapping(value= "/marks/{id}")
    public ResponseEntity<HttpStatus> deleteMarks(@PathVariable("id") Integer id){

        studentMarksRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/students/{id}/marks")
    public ResponseEntity<List<StudentMarks>> deleteAllMarksOfStudent(@PathVariable Integer id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException(id);
        }

        studentMarksRepository.deletebyStudentId(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
