package com.course.service.demo.repository;

import com.course.service.demo.entity.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCourseByCourseId(String courseId);
}
