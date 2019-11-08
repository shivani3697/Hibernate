package com.lti.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Savings")
public class Saving extends Account{
	private double roi;
	
	
	public Saving()
	{
		super();
	}


	public Saving(long accountNumber, String accountHolderName, double accountBalance, double roi) {
		super(accountNumber, accountHolderName, accountBalance);
		
		this.roi=roi;
	}
	public double getRoi() {
		return roi;
	}
	public void setRoi(double roi) {
		this.roi = roi;
	}


	@Override
	public String toString() {
		return "Saving [roi=" + roi + ", toString()=" + super.toString() + "]";
	}
	
}
