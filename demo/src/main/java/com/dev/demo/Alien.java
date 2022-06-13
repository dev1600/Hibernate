package com.dev.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@Table(name="alien_table")
public class Alien {
	
	@Id
	private int aid;
	
// @Transient does not create column in table
//	@Transient
	private AlienName aname;
	
	@Column(name="alien_color")
	private String color;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public AlienName getAname() {
		return aname;
	}
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	
	@Override
	public String toString(){
		return "Alien [aid="+aid+", aname= "+aname+", color= "+color+"]";
	}
	

}
