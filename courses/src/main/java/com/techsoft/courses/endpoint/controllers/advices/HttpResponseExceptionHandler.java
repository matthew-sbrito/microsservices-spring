package com.techsoft.courses.endpoint.controllers.advices;

import com.techsoft.courses.dto.CustomValidationError;
import com.techsoft.courses.dto.ResponseError;
import com.techsoft.courses.dto.ResponseValidationError;
import com.techsoft.courses.exceptions.HttpResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HttpResponseExceptionHandler {

    @ExceptionHandler(HttpResponseException.class)
    public ResponseEntity<ResponseError> handleException(HttpResponseException e) {
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseValidationError> handleException(MethodArgumentNotValidException e){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        List<CustomValidationError> errors =  e.getAllErrors().stream().map(CustomValidationError::new).collect(Collectors.toList());

        ResponseValidationError response = new ResponseValidationError();

        response.setTimestamp(new Date());
        response.setMessage("Error validate domain model!");
        response.setStatus(httpStatus.value());
        response.setError(httpStatus.getReasonPhrase());
        response.setErrors(errors);

        return new ResponseEntity<>(response, httpStatus);
    }
}
