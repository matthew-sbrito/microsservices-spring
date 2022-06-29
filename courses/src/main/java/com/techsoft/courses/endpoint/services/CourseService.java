package com.techsoft.courses.endpoint.services;

import com.techsoft.core.models.Course;
import com.techsoft.core.repositories.CourseRepository;
import com.techsoft.courses.dto.CourseDto;
import com.techsoft.courses.exceptions.HttpResponseException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author Matheus Brito
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseService {
    private final CourseRepository courseRepository;

    public Page<Course> list(Pageable pageable) {
        log.info("Listing all courses");
        return courseRepository.findAll(pageable);
    }

    public Course create(CourseDto courseDto) throws HttpResponseException {
        try {
            log.info("Create new course");
            Course course = new Course();

            BeanUtils.copyProperties(courseDto, course);

            return courseRepository.save(course);
        } catch (Exception ignored){
            log.error("Error save course");
            throw new HttpResponseException(HttpStatus.BAD_REQUEST, "Error occurred while save course");
        }
    }
}
