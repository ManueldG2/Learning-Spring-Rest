package it.iagica.learnig_rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

	    
    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Map<String, List<String>>> handleRuntimeExceptions(RuntimeException ex) {
    	
        List<String> errors = Collections.singletonList(ex.toString());
        System.out.println(ex.getLocalizedMessage());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
    	
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
       
        return errorResponse;
        
    }

   

}