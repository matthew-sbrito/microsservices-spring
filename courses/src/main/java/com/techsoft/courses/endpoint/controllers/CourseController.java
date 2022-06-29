package com.techsoft.courses.endpoint.controllers;

import com.techsoft.core.models.Course;
import com.techsoft.courses.dto.CourseDto;
import com.techsoft.courses.endpoint.services.CourseService;
import com.techsoft.courses.exceptions.HttpResponseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

/**
 * @author Matheus Brito
 */
@Slf4j
@RestController
@RequestMapping("v1/admin/course")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<Page<Course>> findAll(
            @PageableDefault() Pageable pageable
    ) throws HttpResponseException {
        log.info("Request list of course");
        Page<Course> responseBody = courseService.list(pageable);

        if (responseBody.hasContent()) {
            return ResponseEntity.status(OK).body(responseBody);
        }

        log.error("Request fail: fetch course list");
        throw new HttpResponseException(NOT_FOUND, "The courses could not be found!");
    }

    @PostMapping
    public ResponseEntity<Course> create(
            @Valid @RequestBody CourseDto courseDto
    ) throws HttpResponseException {
        Course course = courseService.create(courseDto);
        return ResponseEntity.status(CREATED).body(course);
    }
}
