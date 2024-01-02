package com.example.testing.demo.Exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Integer id){
        super("Could not find "+ id);
    }
}
