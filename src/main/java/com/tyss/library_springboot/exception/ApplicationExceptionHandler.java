package com.tyss.library_springboot.exception;

import com.tyss.library_springboot.structure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler  {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseStructure<String>> catchNullPointerException(NullPointerException nullPointerException){
        ResponseStructure<String> structure=new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.NO_CONTENT.value());
        structure.setMessage("Failed");
        structure.setData(nullPointerException.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NoSuchBookFoundException.class)
    public ResponseEntity<ResponseStructure<String>> catchNoSuchbookFoundException(NoSuchBookFoundException exception){
        ResponseStructure<String> structure=new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.NO_CONTENT.value());
        structure.setMessage("Failed");
        structure.setData(exception.getMessage());
        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NO_CONTENT);
    }

}
