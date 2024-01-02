package com.example.testing.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class StudentMarksNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(StudentMarksNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String studentMarksNotFoundHandler(StudentMarksNotFoundException ex){
        return ex.getMessage();
    }
}
