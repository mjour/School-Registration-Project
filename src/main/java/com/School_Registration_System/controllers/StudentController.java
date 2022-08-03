package com.School_Registration_System.controllers;

import java.util.List;

import javax.validation.Valid;

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
import com.School_Registration_System.dto.StudentDto;
import com.School_Registration_System.exception.BadRequestException;
import com.School_Registration_System.exception.ParameterNotAccepted;
import com.School_Registration_System.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/")
	public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto studentDto) {
		StudentDto createStudentDto = this.studentService.createStudent(studentDto);
		return new ResponseEntity<>(createStudentDto, HttpStatus.CREATED);
	}

	@PutMapping("/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto studentDto,
			@PathVariable("studentId") Integer uid) {
		StudentDto updateStudentDto = this.studentService.updateStudent(studentDto, uid);
		return ResponseEntity.ok(updateStudentDto);
	}

	@GetMapping("/")
	public ResponseEntity<List<StudentDto>> getAllStudent() throws BadRequestException {
		System.out.println("get all Student");
		return ResponseEntity.ok(this.studentService.getAllStudent());
		
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable("studentId") Integer uid) {
		System.out.println("student");
		StudentDto getStudentByIdDto = this.studentService.getStudentById(uid);
		return new ResponseEntity<StudentDto>(getStudentByIdDto, HttpStatus.OK);
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("studentId") Integer uid) {
		this.studentService.deleteStudentById(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	}

	@PostMapping(value = "/students/{id}/register/{course_id}")
	public ResponseEntity<StudentDto> register(@PathVariable("id") Integer id,
			@PathVariable("course_id") Integer course_id) throws ParameterNotAccepted, BadRequestException {
		StudentDto registerStudentDto = this.studentService.register(id, course_id);
		return new ResponseEntity<>(registerStudentDto, HttpStatus.ACCEPTED);
	}

}
