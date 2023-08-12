package com.course.service.demo.services.impl;

import com.course.service.demo.entity.model.Course;
import com.course.service.demo.entity.payload.result.CourseResult;
import com.course.service.demo.repository.CourseRepository;
import com.course.service.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }

    @Override
    public Course updateCourse(Course course) {
        return null;
    }

    @Override
    public Course getCourseByCourseId(String courseId) {
        return null;
    }

    @Override
    public void deleteCourseByCourseId(String courseId) {

    }
}
