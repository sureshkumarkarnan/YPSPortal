package com.yps.ypsconnect.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEACHER")
public class Teacher {

	@Id
	@Column(name = "TEACHER_ID")
    private Integer regId;
	
	@Column(name = "FNAME", nullable=false, unique=false)
    private String fname;
	
	@Column(name = "LNAME", nullable=false, unique=false)
    private String lname;
	
	@Column(name = "DATEJOINED", nullable=false)
    private Date dateJoined;
	

	public Integer getRegId() {
		return regId;
	}


	public void setRegId(Integer regId) {
		this.regId = regId;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public Date getDateJoined() {
		return dateJoined;
	}


	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}


	public Number getSalary() {
		return salary;
	}


	public void setSalary(Number salary) {
		this.salary = salary;
	}


	@Column(name = "SALARY",nullable=false)
    private Number  salary;
}
