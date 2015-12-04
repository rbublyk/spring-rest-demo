package com.dataart.rbublyk.exception.handler;

import com.dataart.rbublyk.exception.ExceptionDetail;
import com.dataart.rbublyk.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException exception, HttpServletRequest request){
        ExceptionDetail detail = new ExceptionDetail();
        detail.setStatus(HttpStatus.NOT_FOUND.value());
        detail.setMessage(exception.getMessage());
        return new ResponseEntity<Object>(detail, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception, HttpServletRequest request){
        ExceptionDetail detail = new ExceptionDetail();
        detail.setStatus(HttpStatus.NOT_FOUND.value());
        detail.setMessage("Account not found");
        return new ResponseEntity<Object>(detail, null, HttpStatus.NOT_FOUND);
    }
}
