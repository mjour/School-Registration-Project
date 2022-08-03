package com.School_Registration_System.controllers;

import com.School_Registration_System.repository.StudentRepo;
import com.School_Registration_System.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School_Registration_System.exception.BadRequestException;
import com.School_Registration_System.exception.ResourceNotFoundException;
import com.School_Registration_System.model.Course;
import com.School_Registration_System.model.Student;
import com.School_Registration_System.repository.CourseRepo;

@RestController
@RequestMapping(value = "/api")
public class RegistrationController {
    @Autowired
    private StudentRepo studentRepo ;

    @Autowired
    private CourseRepo coursesRepo;
    
    @Autowired
	private CommonUtil util;

    
    @GetMapping("/register/course/{id}/students")
	  public ResponseEntity<?>   getCourseStudents(@PathVariable("id") Integer id) throws BadRequestException
	  { Optional<Course> courseData =  Optional.ofNullable(coursesRepo.findById(id).orElseThrow(() ->new  ResourceNotFoundException("Course", "Course Id",id )));
	   if (courseData!=null) { 
		    Course course = courseData.get();
		   if(course.getStudents().size()==0)
		   {
			   return new
						  ResponseEntity<>(util.genResponse(HttpStatus.OK, "No student was registered in this course", null),
						  HttpStatus.OK);   
			  }
		   else { 
			   System.out.println("Else1");
				
			  return new ResponseEntity<>(new ArrayList<Student>(course.getStudents()),
				   HttpStatus.OK);
			  }
	    }
	   else { 
		  return new
	  ResponseEntity<>(util.genResponse(HttpStatus.OK, "Success", null),
	  HttpStatus.OK);
	  
	  } 
	   
	  }
    
    @GetMapping("/register/student/{id}/courses") 
	  public ResponseEntity<?> getStudentCourses(@PathVariable("id") Integer id) {
		
	  Optional<Student> studentData =  Optional.ofNullable(studentRepo.findById(id).orElseThrow(() ->new ResourceNotFoundException("Student", "Student Id",id)));
	  
	  if (studentData.isPresent()) { 
		  Student student = studentData.get();
		  if(student.getCourses().size()==0) {
			  return new
					  ResponseEntity<>(util.genResponse(HttpStatus.OK, "this Student has not Enroll in any courses", null),
					  HttpStatus.OK);   
			  
		  }
		  else {
			  return new ResponseEntity<>(new ArrayList<Course>(student.getCourses()),
	  HttpStatus.OK); } }
	  else { 
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	  }
    
    
   
    
    @GetMapping("/register/studentsWithoutAnyCourses") 
	  public ResponseEntity<?> getStudentsWithoutAnyCourses() {
	  try {
	  List<Student> students = studentRepo.findAll().stream() .filter(p ->
	  p.getCourses().size() == 0) .collect(Collectors.toList());
	  System.out.print("this is course+"+students.size());
	  if(students.size()==0)
	  {
		  return new
				  ResponseEntity<>(util.genResponse(HttpStatus.OK, "there was no student without any course", null),
				  HttpStatus.OK);   
	  }
	  else {
	  
		  return new ResponseEntity<>(util.genResponse(HttpStatus.OK, "Success", students), HttpStatus.OK);
	  }
	  } catch (Exception e) {
		  
	  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } 
	  }
	  
  
  
     @GetMapping("/register/coursesWithoutAnyStudents")
	   public ResponseEntity<?> getCoursesWithoutAnyCourses() { 
		  try {
	      List<Course> courses = coursesRepo.findAll().stream() .filter(p ->
	      p.getStudents().size() == 0) .collect(Collectors.toList()); 
	        if(courses.size()==0)
	        {
		     return new ResponseEntity<>(util.genResponse(HttpStatus.OK, "this Student has not Enroll in any courses", null),
				  HttpStatus.OK);  
	         }
	       else {
	    	   return new ResponseEntity<>(util.genResponse(HttpStatus.OK, "Success", courses), HttpStatus.OK);
	   }

	   } catch (Exception e)
		  {
	  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); }
		  }
	 
	
}
