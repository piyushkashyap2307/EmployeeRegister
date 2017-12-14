package main.java.com.jensen.employeeregister.model.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="employees")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int id;

	@NotNull
	@Column(name = "fname")
	private String firstname;

	@NotNull
	@Column(name = "lname")
	private String lastname;

	@NotNull
	@Column(name = "location")
	private String location;
	
	@NotNull
	@Column(name = "role")
	private String role;
	
	@Column(name = "registration_date")
	private Date registrationDate;
	
	/**
	 * Default Constructor of the Employee.class
	 */
	public Employee(){

	}
	
	public Employee(String firstname, String lastname, String location, String role) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.location = location;
		this.role = role;
	}
	
	public Employee(int id, String firstname, String lastname, String location, String role, Date registrationDate) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.location = location;
		this.role = role;
		this.registrationDate = registrationDate;
	}
	/**
	 * 
	 * @return This Object's Id
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * 
	 * @param id Sets this Object's Id
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return This Object's firstName
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * 
	 * @param firstname Sets this Object's firstName
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * 
	 * @return This Object's LastNaem
	 */
	public String getLastname() {
		return this.lastname;
	}
	/**
	 * 
	 * @param lastname Sets this Object's LastName
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTown() {
		return location;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public void setTown(String town) {
		this.location = town;
	}

}
