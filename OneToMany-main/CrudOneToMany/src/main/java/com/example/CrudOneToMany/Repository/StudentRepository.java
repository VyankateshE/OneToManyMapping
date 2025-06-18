package com.example.CrudOneToMany.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CrudOneToMany.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
