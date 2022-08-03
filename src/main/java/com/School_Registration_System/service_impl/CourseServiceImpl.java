package com.School_Registration_System.service_impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School_Registration_System.dto.CourseDto;
import com.School_Registration_System.exception.BadRequestException;
import com.School_Registration_System.exception.ResourceNotFoundException;
import com.School_Registration_System.model.Course;
import com.School_Registration_System.repository.CourseRepo;
import com.School_Registration_System.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CourseRepo courseRepo;

	@Override
	public CourseDto createCourse(CourseDto courseDto) {
		Course course = this.modelMapper.map(courseDto, Course.class);
		Course added = this.courseRepo.save(course);
		return this.modelMapper.map(added, CourseDto.class);
	}

	@Override
	public CourseDto updatecourse(CourseDto courseDto, Integer courseId) {
		Course course = this.courseRepo.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Course Id", courseId));
		course.setName(courseDto.getName());
		Course update = this.courseRepo.save(course);
		return this.modelMapper.map(update, CourseDto.class);
	}

	@Override
	public void deleteCourse(Integer courseId) {
		Course course = this.courseRepo.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Course Id", courseId));
		this.courseRepo.delete(course);
	}

	@Override
	public List<CourseDto> getAllCourse() throws BadRequestException {
		List<Course> courses = this.courseRepo.findAll();
		List<CourseDto> Dto = courses.stream().map((cat) -> this.modelMapper.map(cat, CourseDto.class))
				.collect(Collectors.toList());
		if(!Dto.isEmpty()) {
			return Dto;
		}else {
			throw new BadRequestException("200", "course are not Available");
		}
      }

	@Override
	public CourseDto getCourseById(Integer courseId) {
		Course course = this.courseRepo.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Course Id", courseId));

		return this.modelMapper.map(course, CourseDto.class);
	}

}
