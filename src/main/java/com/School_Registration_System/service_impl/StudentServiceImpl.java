package com.School_Registration_System.service_impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School_Registration_System.StudentRegistrationCoursesApplication;
import com.School_Registration_System.dto.StudentDto;
import com.School_Registration_System.exception.BadRequestException;
import com.School_Registration_System.exception.ParameterNotAccepted;
import com.School_Registration_System.exception.ResourceNotFoundException;
import com.School_Registration_System.model.Course;
import com.School_Registration_System.model.Student;
import com.School_Registration_System.repository.CourseRepo;
import com.School_Registration_System.repository.StudentRepo;
import com.School_Registration_System.service.StudentService;



@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private CourseRepo courseRepo;

	@Override
	public StudentDto createStudent(StudentDto studentdto) {
		Student student = this.modelMapper.map(studentdto, Student.class);
		Student added = this.studentRepo.save(student);
		return this.modelMapper.map(added, StudentDto.class);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentdto, Integer studentId) {
		Student student = this.studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "Student Id", studentId));
		student.setFirstName(studentdto.getFirstName());
		student.setLastName(studentdto.getLastName());
		Student updated = this.studentRepo.save(student);

		return this.modelMapper.map(updated, StudentDto.class);
	}

	@Override
	public void deleteStudentById(Integer studentId) {
		Student student = this.studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "Student Id", studentId));
		this.studentRepo.delete(student);

	}

	@Override
	public List<StudentDto> getAllStudent() throws BadRequestException {
		List<Student> students = this.studentRepo.findAll();
		students.forEach(games -> System.out.println(games));  
		List<StudentDto> Dto = students.stream().map((cat) -> this.modelMapper.map(cat, StudentDto.class))
				.collect(Collectors.toList());
		if(!Dto.isEmpty()) {
			return Dto;
		}else {
			throw new BadRequestException("200", "student are not Available");
		}
		
	}

	@Override
	public StudentDto getStudentById(Integer studentId) {

		Student student = this.studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "Student Id", studentId));

		return this.modelMapper.map(student, StudentDto.class);
	}

	public StudentDto register(Integer StudentId, Integer courseId) throws ParameterNotAccepted, BadRequestException {
		Student student = this.studentRepo.findById(StudentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "Student Id", StudentId));
		Course course = this.courseRepo.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Course Id", courseId));

		if (student != null && course != null) {
			Student _student = student;
			Course _course = course;

			if (_student.getCourses().size() < StudentRegistrationCoursesApplication.COURSES_LIMIT
					&& _course.getStudents().size() < StudentRegistrationCoursesApplication.STUDENTS_LIMIT) {

				_student.getCourses().add(_course);
				Student register1 = this.studentRepo.save(_student);
				return this.modelMapper.map(register1, StudentDto.class);

			} else {
				throw new BadRequestException("200", "Registration is Full. you can't register more than 5 course");
			}
		} else {
			return null;
		}
	}

}
