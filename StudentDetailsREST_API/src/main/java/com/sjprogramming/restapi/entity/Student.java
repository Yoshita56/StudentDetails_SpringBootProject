package com.sjprogramming.restapi.entity;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table //creates a table with the default class name, here, 'Student'
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY) 
private int rollno; //automatically incremented by new addition of details.
@Column(name="std_name")
private String name;
@Column(name="std_percent")
private float percentage;
@Column(name="std_course")
private String course;

public Student() {
	//default constructor is needed to avoid error idk why
}
 
public Student(String name, float percentage, String course) {
	super();
	this.name = name;
	this.percentage = percentage;
	this.course = course;
}

public int getRollno() {
	return rollno;
}

public void setRollno(int rollno) {
	this.rollno = rollno;
}

public float getPercentage() {
	return percentage;
}
public void setPercentage(float percentage) {
	this.percentage = percentage;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
@Override
public String toString() {
	return "Student [rollno=" + rollno + ", name=" + name + ", percentage=" + percentage + ", course=" + course + "]";
}


}
