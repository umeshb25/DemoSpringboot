package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Student;

@Service
public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(Long id);

	Student updateStudent(int id, Student updatedStudent);

	Student getStudentById(int id);

	Student deleteStudent(int id);


}
