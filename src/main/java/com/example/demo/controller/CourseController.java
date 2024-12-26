package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Course;
import com.example.demo.service.CourseService;


@RestController
@RequestMapping("/course")
public class CourseController {

	
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public Course createcourse(@RequestBody Course course) {
		Course c1= courseService.savecourse(course);
		return c1;
		
	}
}
