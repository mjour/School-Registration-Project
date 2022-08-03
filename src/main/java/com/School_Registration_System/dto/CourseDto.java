package com.School_Registration_System.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class CourseDto {
	
	   private Integer id;
	
	   @NotEmpty
		@Size(min = 4, message = "Coursename must be min of 4 characters !!")
	    private String name;
	    
	    


		public CourseDto() {
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
	    
	    
}
