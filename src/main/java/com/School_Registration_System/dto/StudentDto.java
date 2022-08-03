package com.School_Registration_System.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.School_Registration_System.model.Course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class StudentDto {
	private long id;
	@NotEmpty
	@Size(min = 4, message = "Studentname must be min of 4 characters !!")
    private String firstName;
    private String lastName;
    private Set<CourseDto> courses = new HashSet<>();
    
    
    
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentDto(@NotEmpty @Size(min = 4, message = "Studentname must be min of 4 characters !!") String firstName,
			String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<CourseDto> getCourses() {
		return courses;
	}
	public void setCourses(Set<CourseDto> courses) {
		this.courses = courses;
	}
    
    

}
