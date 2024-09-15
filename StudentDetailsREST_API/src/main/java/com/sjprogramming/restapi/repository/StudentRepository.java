package com.sjprogramming.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjprogramming.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
//the interface is inheriting the properties of the main class JPA spring boot to access its methods like: .save(), findbyid(), delete(), findAll(), etc
}
