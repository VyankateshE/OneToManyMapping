package com.example.CrudOneToMany.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data@JsonPropertyOrder({"studentRoll", "studentName", "studentAge", "course"}) // Specify the order explicitly
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@JsonProperty("studentRoll")
	private Long studentRoll;
	
	@Size(min = 2,message = "name must have more then 1 letter")
	@NotNull(message ="Name is Required!")
	private String studentName;
	
	@NotNull(message = "Age is Required")
	private int studentAge;
	
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
	private List<Course> course;

}
