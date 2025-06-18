package com.example.CrudOneToMany.Controller;

import java.util.List;

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

import com.example.CrudOneToMany.Bean.CourseBean;
import com.example.CrudOneToMany.Bean.StudentBean;
import com.example.CrudOneToMany.Model.Course;
import com.example.CrudOneToMany.Services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courSevice;
	
	@PostMapping("/{id}")
	public ResponseEntity<String> saveCourse(@RequestBody CourseBean request,@PathVariable Long id){
		
		String save = courSevice.saveCourse(request,id);
		
		return new ResponseEntity<String>(save,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Course>> getCourseData(){
		List<Course> data = courSevice.getCourseData();
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Long id){
	  String delete= courSevice.deleteCourse(id);
	  return new ResponseEntity<>(delete,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCourse(@PathVariable Long id,@RequestBody CourseBean courBean){
		String update = courSevice.updateCourse(id,courBean);
		  return new ResponseEntity<>(update,HttpStatus.OK);

	}
}
