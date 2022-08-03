package com.School_Registration_System;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentRegistrationCoursesApplication {
  
	
    public static final int COURSES_LIMIT = 5;
    public static final int STUDENTS_LIMIT = 50;
    
    
	public static void main(String[] args) {
		SpringApplication.run(StudentRegistrationCoursesApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}



}
