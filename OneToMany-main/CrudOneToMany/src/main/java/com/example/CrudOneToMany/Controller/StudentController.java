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

import com.example.CrudOneToMany.Bean.StudentBean;
import com.example.CrudOneToMany.Model.Student;
import com.example.CrudOneToMany.Services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studService;
	
	@PostMapping
	public ResponseEntity<String> saveStudent(@RequestBody StudentBean request){
		String save = studService.saveStudent(request);
		return new ResponseEntity<String>(save,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudentData(){
		List<Student> data= studService.getStudentData();
		return new ResponseEntity<List<Student>>(data,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id){
	  String delete= studService.deleteStudent(id);
	  return new ResponseEntity<>(delete,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Long id,@RequestBody StudentBean studBean){
		String update =studService.updateStudent(id,studBean);
		  return new ResponseEntity<>(update,HttpStatus.OK);

	}
}
