package com.School_Registration_System.service;

import java.util.List;

import com.School_Registration_System.dto.StudentDto;
import com.School_Registration_System.exception.BadRequestException;
import com.School_Registration_System.exception.ParameterNotAccepted;


public interface StudentService {
	
	StudentDto createStudent(StudentDto studentdto );

	StudentDto updateStudent(StudentDto studentdto ,Integer studendId);

    void  deleteStudentById(Integer studentId);

    List<StudentDto> getAllStudent() throws BadRequestException;

    StudentDto getStudentById(Integer studentId);
    StudentDto register(Integer StudentId, Integer course_id) throws BadRequestException, ParameterNotAccepted ;
    
    
	
}
