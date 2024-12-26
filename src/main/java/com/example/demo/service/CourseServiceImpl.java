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
	
}
