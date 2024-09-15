package com.sjprogramming.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sjprogramming.restapi.entity.Student;
import com.sjprogramming.restapi.repository.StudentRepository;

@RestController

public class StudentController {
// get all the students 
	
	@Autowired
	StudentRepository repo; //using this interface to use the methods of JPA repository class
	
	//localhost:8080/students --> PostMan URL/URI (REST POINT)
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> students=repo.findAll();
		//model.addAttribute("listofstudents", students);
		System.out.print("Get / ");  
		return students;
	}
	
	//localhost:8080/students/1
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student std= repo.findById(id).get();
		//fetching the student details by their resp roll.no.
		return std;
	}
	
	@PostMapping("/students/enter") //POST option is used in Postman
	@ResponseStatus(code=HttpStatus.CREATED) //changes 200 OK to 201 OK in postman means Created
	public void createStudent(@RequestBody Student student){
		repo.save(student);
		
	}
	
	//Update the existing details
	@PutMapping("/students/updateID/{id}")
	public Student updateStudents(@PathVariable int id) {
		Student student=repo.findById(id).get();
		student.setName("Poonam");
		student.setPercentage(92);
		repo.save(student); //this line is very important to commit the changes in the database
		return student;
	}
	
	@DeleteMapping("/students/deleteID/{id}")
	public ResponseEntity<String> deleteStudents(@PathVariable int id) {
		Student student=repo.findById(id).get();
		repo.delete(student); //this line is very important to commit the changes in the database
		return ResponseEntity.status(HttpStatus.CREATED).body("the record has been deleted"); //used to show message in the Postman Body -> ResponseEntity<> class
	} //method can be void but I chose to return the JSON data to keep the track of the data that is being handled.
}
