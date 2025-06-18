package com.example.CrudOneToMany.Services;

import java.util.List;

import com.example.CrudOneToMany.Bean.CourseBean;
import com.example.CrudOneToMany.Bean.StudentBean;
import com.example.CrudOneToMany.Model.Course;

public interface CourseService {

	String saveCourse(CourseBean request, Long id);

	List<Course> getCourseData();

	String deleteCourse(Long id);

	String updateCourse(Long id, CourseBean courBean);

}
