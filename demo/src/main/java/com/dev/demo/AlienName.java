package com.dev.demo;

import javax.persistence.Embeddable;


// We use Embeddable to tell that we need not create another table for this 
// this will make sure it is stored in the same table 
@Embeddable
public class AlienName {
	private String fname;
	private String mname;
	private String lname;
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Override
	public String toString() {
		return "AlienName [fname=" + fname + ", mname=" + mname + ", lname=" + lname + "]";
	}
	
	
}
