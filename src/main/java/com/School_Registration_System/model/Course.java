package com.School_Registration_System.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")


public class Course {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    
    @Column(name = "name")
    private String name;
    
    
    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Student> students = new HashSet<>();
    
    


	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}


	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}
    
    

}
