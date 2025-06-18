package com.example.CrudOneToMany.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudOneToMany.Bean.StudentBean;
import com.example.CrudOneToMany.Model.Course;
import com.example.CrudOneToMany.Model.Student;
import com.example.CrudOneToMany.Repository.CourseRepository;
import com.example.CrudOneToMany.Repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	StudentRepository studRepo;
	
	@Autowired
	CourseRepository courseRepo;

	@Override
	public String saveStudent(StudentBean request) {
		Student stud = new Student();
		stud.setStudentName(request.getStudentName());
		stud.setStudentAge(request.getStudentAge());
		studRepo.save(stud);
		return "Student Saved Successfull!";
	}

	@Override
	public List<Student> getStudentData() {
		// TODO Auto-generated method stub
		return studRepo.findAll();
	}

	@Override
	public String deleteStudent(Long id) {
		studRepo.deleteById(id);
		return "Student Data Deleted Succesfully!";
	}

	@Override
	public String updateStudent(Long id,StudentBean studBean) {
		// TODO Auto-generated method stub
		Optional<Student> stud = studRepo.findById(id);
		
		if(stud.isPresent()) {
			Student data = stud.get();
			data.setStudentName(studBean.getStudentName());
			data.setStudentAge(studBean.getStudentAge());
			studRepo.save(data);
			return "Student Data Updated Succesfully!";
		}else {
		return "Student with ID "+id+" not found!";
		}
	}

}
