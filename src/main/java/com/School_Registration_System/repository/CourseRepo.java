package com.School_Registration_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.School_Registration_System.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{
   
}
