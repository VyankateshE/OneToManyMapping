package com.example.CrudOneToMany.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudOneToMany.Bean.CourseBean;
import com.example.CrudOneToMany.Bean.StudentBean;
import com.example.CrudOneToMany.Model.Course;
import com.example.CrudOneToMany.Model.Student;
import com.example.CrudOneToMany.Repository.CourseRepository;
import com.example.CrudOneToMany.Repository.StudentRepository;

@Service
public class CourseServiceImp implements CourseService{
	
	@Autowired
	StudentRepository studRepo;
	
	@Autowired
	CourseRepository courseRepo;


	@Override
	public String saveCourse(CourseBean request, Long id) {
		Student stud = studRepo.findById(id).orElseThrow(()-> new RuntimeException("User not Found with Id "));

		
		// TODO Auto-generated method stub
		if (courseRepo.existsByStudentStudentRollAndCourseName(id, request.getCourseName())) {
	        return "Course '" + request.getCourseName() + "' is already taken by You!";
	    } else {
	        Course course = new Course();
	        course.setCourseName(request.getCourseName());
	        course.setStudent(stud);
	        courseRepo.save(course);
	        return "Course saved successfully!";
	    }
	}


	@Override
	public List<Course> getCourseData() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}


	@Override
	public String deleteCourse(Long id) {
		// TODO Auto-generated method stub
		courseRepo.deleteById(id);
		return "Course "+id +"Deleted Succesfully!";
	}


	@Override
	public String updateCourse(Long id, CourseBean courBean) {
     Optional<Course> stud = courseRepo.findById(id);
		
		if(stud.isPresent()) {
			Course data = stud.get();
			data.setCourseName(courBean.getCourseName());
			courseRepo.save(data);
			return "Course Data Updated Succesfully!";
		}else {
		return "Course with ID "+id+" not found!";
		}
	}

}
