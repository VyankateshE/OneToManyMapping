package com.example.CrudOneToMany.Services;

import java.util.List;

import com.example.CrudOneToMany.Bean.StudentBean;
import com.example.CrudOneToMany.Model.Student;

public interface StudentService {

	String saveStudent(StudentBean request);

	List<Student> getStudentData();

	String deleteStudent(Long id);

	String updateStudent(Long id,StudentBean studBean);

}
