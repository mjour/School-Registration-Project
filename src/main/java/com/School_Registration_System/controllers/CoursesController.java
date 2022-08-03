package com.School_Registration_System.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School_Registration_System.dto.ApiResponse;
import com.School_Registration_System.dto.CourseDto;
import com.School_Registration_System.exception.BadRequestException;
import com.School_Registration_System.model.Course;
import com.School_Registration_System.service.CourseService;
import com.School_Registration_System.util.CommonUtil;

@RestController
@RequestMapping("/api/course")
public class CoursesController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private CommonUtil util;
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/")
	public ResponseEntity<?> createCourse(@Valid @RequestBody CourseDto courseDto) {
		CourseDto createStudentDto = this.courseService.createCourse(courseDto);
		Course postRequest = modelMapper.map(createStudentDto, Course.class);
		return new ResponseEntity<>(util.genResponse(HttpStatus.OK, "Success", postRequest), HttpStatus.OK);

	}

	@PutMapping("/{courseId}")
	public ResponseEntity<?> updateCourse(@Valid @RequestBody CourseDto courseDto,
			@PathVariable("courseId") Integer uid) {
		CourseDto updateStudentDto = this.courseService.updatecourse(courseDto, uid);
		Course postRequest = modelMapper.map(updateStudentDto, Course.class);
		return new ResponseEntity<>(util.genResponse(HttpStatus.OK, "edit sucessfully", postRequest), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<CourseDto>> getAllCourse() throws BadRequestException {
		System.out.println("get all course");
		return ResponseEntity.ok(this.courseService.getAllCourse());
	}

	@GetMapping("/{courseId}")
	public ResponseEntity<CourseDto> getSingleCourse(@PathVariable Integer courseId) {
		return ResponseEntity.ok(this.courseService.getCourseById(courseId));
	}

	@DeleteMapping("/{courseId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("courseId") Integer uid) {
		this.courseService.deleteCourse(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	}

}
