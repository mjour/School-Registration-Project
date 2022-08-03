package com.School_Registration_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.School_Registration_System.model.Student;


public interface StudentRepo extends JpaRepository<Student, Integer>{
   
}
