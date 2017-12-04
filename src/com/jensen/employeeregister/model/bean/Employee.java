package com.jensen.employeeregister.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

@Entity(name = "employees")
@Service
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fname", nullable = false)
	private String fname;
	
	@Column(name = "lname", nullable = false)
	private String Lname;
	
	@Column(name = "town", nullable = false)
	private String town;
	
	public Employee() {
		
	}
	public Employee(String fname, String lname, String town) {
		this.fname = fname;
		this.Lname = lname;
		this.town = town;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", Lname=" + Lname + ", town=" + town + "]";
	}

}
