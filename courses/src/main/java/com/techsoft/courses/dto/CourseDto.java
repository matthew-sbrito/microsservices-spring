package com.techsoft.courses.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CourseDto {

    @NotNull(message = "The field 'title' is mandatory")
    @NotBlank(message = "The field 'title' is mandatory")
    @Size(min = 6, max = 50, message = "The field 'title' must contain between 6 and 20 characters")
    private String title;
}
