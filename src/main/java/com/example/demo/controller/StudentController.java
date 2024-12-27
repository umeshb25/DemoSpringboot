package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/students")
public class StudentController {
	
	
	@Autowired
	private StudentService studentservice;
	
	 @PostMapping
	    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
	        Student savedStudent = studentservice.saveStudent(student);
	        return ResponseEntity.ok(savedStudent);
	    }

	    @GetMapping
	    public ResponseEntity<List<Student>> getAllStudents() {
	        List<Student> students = studentservice.getAllStudents();
	        return ResponseEntity.ok(students);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student Student) {
	        Student student = studentservice.updateStudent(id, Student);
	        
	        if (student == null) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        return ResponseEntity.ok(student);  
	    }
	    
	    
	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int id){
		Student student= studentservice.deleteStudent(id);
	
   return ResponseEntity.ok(student);
}
}

