package com.School_Registration_System.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")

public class Student {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
         
	   
		
	    @Column(name="first_name")
	    private String firstName;

	    @Column(name="last_name")
	    private String lastName;
     
	    
	    
	    
	    @ManyToMany(fetch = FetchType.EAGER)
	    @JsonIgnore
	    @JoinTable(
	            name = "students_courses",
	            joinColumns = @JoinColumn(name="student_id"),
	            inverseJoinColumns = @JoinColumn(name = "course_id"))
	           private Set<Course> courses = new HashSet<>();
	    
	    


		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}


		


		





//		public Student(String firstName, String lastName) {
//			super();
//			this.firstName = firstName;
//			this.lastName = lastName;
//		}






		







		public Student(int id, String firstName, String lastName) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}




//		public Student(int id2, String firstName2, String lastName2) {
//			// TODO Auto-generated constructor stub
//		}











		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
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


		public Set<Course> getCourses() {
			return courses;
		}


		public void setCourses(Set<Course> courses) {
			this.courses = courses;
		}











		public static Object builder() {
			// TODO Auto-generated method stub
			return null;
		}











		@Override
		public String toString() {
			return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", courses=" + courses
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}











		
	    

}
