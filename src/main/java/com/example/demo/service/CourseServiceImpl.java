package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Course;
import com.example.demo.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Course savecourse(Course course1) {
        return courseRepo.save(course1);
    }

    @Override
    public Course getCourse(Long courseId) {
        return courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));
    }
    
    @Override
    public Course updateCourse(Long courseId, Course course) {
        Course existingCourse = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setCourseCode(course.getCourseCode());
        existingCourse.setPrice(course.getPrice());

        return courseRepo.save(existingCourse);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course existingCourse = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

        courseRepo.delete(existingCourse);
    }
}
