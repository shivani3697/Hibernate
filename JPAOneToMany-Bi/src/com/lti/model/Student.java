package com.lti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "Student")
@SequenceGenerator(name= "seq",sequenceName= "seq_student",initialValue = 1, allocationSize = 1)
public class Student implements Serializable {

		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
		private int studentId;
		private int rollNumber;
		private String studentName;
		private double avgScore;
		@Transient
		private String dob;
		
		@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		@JoinColumn(name="addressId")
		private Address address;
		
		
		public Student() {
			super();
		}
		
	
		public Student(int rollNumber, String studentName, double avgScore) {
			super();
			
			this.rollNumber = rollNumber;
			this.studentName = studentName;
			this.avgScore = avgScore;
		}
		public int getStudentId() {
			return studentId;
		}
		public void setStudentId(int studentId) {
			this.studentId = studentId;
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
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		
		public Address getAddress() {
			return address;
		}


		public void setAddress(Address address) {
			this.address = address;
		}


		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", rollNumber=" + rollNumber + ", studentName=" + studentName
					+ ", avgScore=" + avgScore + ", dob=" + dob +  "]";
		}


		

		
		
	
		

		

		
}
