package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
@SequenceGenerator(name= "seq",sequenceName="rollno_seq",initialValue=1,allocationSize=1)
public class Student implements Serializable {
	@Id 	//to create primary key
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator= "seq")
	@Column(name = "Roll_no")	//coloumn name from table
	private int rollNumber;
	
	@Column(name ="Student_name")
	private String studentName;
	
	@Column(name ="Avg_score")	//not case sensitive
	private double avgScore;
	
	public Student() {
		super();
	}
	
	public Student(int rollNumber, String studentName, double avgScore) {
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.avgScore = avgScore;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", studentName=" + studentName + ", avgScore=" + avgScore + "]";
	}
	
	
	
}
