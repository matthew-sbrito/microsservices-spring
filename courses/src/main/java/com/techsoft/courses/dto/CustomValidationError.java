package com.techsoft.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.ObjectError;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomValidationError {
    private String model;
    private String message;
    private String validation;

    public CustomValidationError(ObjectError error) {
        model = error.getObjectName();
        message = error.getDefaultMessage();
        validation = error.getCode();
    }
}