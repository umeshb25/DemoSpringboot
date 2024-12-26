package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    Optional<Course> findById(Long courseId);  // Accept Long instead of Course
}
