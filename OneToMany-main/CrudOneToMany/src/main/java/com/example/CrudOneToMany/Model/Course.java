package com.example.CrudOneToMany.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseId;
	
	@NotNull(message = "Course is required!")
	private String courseName;
	
	@ManyToOne
	@JoinColumn(name = "studentRoll")
	@JsonIgnore
	private Student student;
	
}
