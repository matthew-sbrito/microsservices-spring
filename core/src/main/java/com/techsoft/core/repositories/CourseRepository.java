package com.techsoft.core.repositories;

import com.techsoft.core.models.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Matheus Brio
 */
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
