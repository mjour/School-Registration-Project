package com.School_Registration_System.service;

import java.util.List;

import com.School_Registration_System.dto.CourseDto;
import com.School_Registration_System.exception.BadRequestException;


public interface CourseService {

	CourseDto createCourse(	CourseDto coursedto );
	
	CourseDto updatecourse(CourseDto coursedto ,Integer courseId);
	
    void  deleteCourse(Integer courseId);
    
	CourseDto getCourseById(Integer courseId);

	List<CourseDto> getAllCourse() throws BadRequestException;
	
	}
