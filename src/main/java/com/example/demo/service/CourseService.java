package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Course;

public interface CourseService {

	Course savecourse(Course course1);

	Course getCourse(Long courseId);

	Course updateCourse(Long courseId, Course course);

    void deleteCourse(Long courseId);
  



	
}
