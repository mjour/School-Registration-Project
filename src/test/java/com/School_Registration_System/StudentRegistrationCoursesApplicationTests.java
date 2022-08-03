package com.School_Registration_System;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.School_Registration_System.exception.BadRequestException;
import com.School_Registration_System.model.Student;
import com.School_Registration_System.repository.StudentRepo;
import com.School_Registration_System.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentRegistrationCoursesApplicationTests {
	
	@Autowired
	private StudentService service;
	
	@MockBean	
	private StudentRepo studentRepo;
	
	

//	@Test
//	void contextLoads() {
//	}
//	
	
	@Test
	public void getAllStudent() throws BadRequestException {
		when(studentRepo.findAll()).thenReturn(Stream
				.of(new Student(1,"Danile","mourya"), new Student(2, "Huy", "test")).collect(Collectors.toList()));
		assertEquals(2, service.getAllStudent().size());
		
	}
	
	
	
	
	
    
 
	
	
	
	
}
