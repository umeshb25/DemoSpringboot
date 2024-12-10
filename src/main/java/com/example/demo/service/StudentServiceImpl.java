package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

//    @Override
//    public Student getStudentById(Long id) {
//        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
//    }
}

