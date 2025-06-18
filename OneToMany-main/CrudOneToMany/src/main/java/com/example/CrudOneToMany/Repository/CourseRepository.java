package com.example.CrudOneToMany.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CrudOneToMany.Model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	void save(List<Course> courses);

	boolean existsByStudentStudentRollAndCourseName(Long id, String courseName);

}
