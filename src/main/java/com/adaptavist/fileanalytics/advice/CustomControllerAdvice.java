package com.adaptavist.fileanalytics.advice;

import com.adaptavist.fileanalytics.exception.OpenFileException;
import com.adaptavist.fileanalytics.exception.ReadFileException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(OpenFileException.class)
    public ResponseEntity<String> handleOpenFile(OpenFileException fileException){
        return new ResponseEntity<String>(fileException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReadFileException.class)
    public ResponseEntity<String> handleReadFile(ReadFileException fileException){
        return new ResponseEntity<String>(fileException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
