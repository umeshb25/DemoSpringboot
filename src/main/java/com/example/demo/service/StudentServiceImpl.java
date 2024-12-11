package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
	public Student getStudentById(int id) {

		return studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
	}

	@Override
	public Student updateStudent(int id, Student Student) {
		Student student = studentRepository.findById(id).orElse(null);

		if (student == null) {
			System.out.println("Student not found");
			return null;
		} else {

			student.setName(Student.getName());
			student.setAge(Student.getAge());

			return studentRepository.save(student);
		}
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student deleteStudent(int id) {

		Student student = studentRepository.findById(id).orElse(null);

		if (student == null) {

			throw new RuntimeException("Student not found with id: " + id);
		}

		studentRepository.deleteById(id);

		return student;
	}

}
