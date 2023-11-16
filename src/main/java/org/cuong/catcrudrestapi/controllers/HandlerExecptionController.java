package org.cuong.catcrudrestapi.controllers;

import org.cuong.catcrudrestapi.exception.CatNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerExecptionController {
    
    @ExceptionHandler(CatNotFoundException.class)
    public ResponseEntity<String> deleteCatById(CatNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
