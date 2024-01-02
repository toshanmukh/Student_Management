package com.example.testing.demo.Exceptions;

public class StudentMarksNotFoundException extends RuntimeException {

    public StudentMarksNotFoundException(Integer id){
        super("Could not find "+ id);
    }
}
