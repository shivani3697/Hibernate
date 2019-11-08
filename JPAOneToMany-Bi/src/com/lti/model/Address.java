package com.lti.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name= "Address")
@SequenceGenerator(name= "seq",sequenceName= "seq_address",initialValue = 1, allocationSize = 1)
public class Address implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	private int addressId;
	private String city,state,pin;
	@OneToOne(mappedBy="address")
	private Student student;
	
	public Address(){
		
	}
	
	public Address(String city, String state, String pin) {
		super();
		
		this.city = city;
		this.state = state;
		this.pin = pin;
	}
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", state=" + state + ", pin=" + pin + "]";
	}

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}

	
}
