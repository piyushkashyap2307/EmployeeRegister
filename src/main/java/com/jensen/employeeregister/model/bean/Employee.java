package main.java.com.jensen.employeeregister.model.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
/**
 * 
 * This Class is the EntityType of a Employee
 * 
 * @author Kami Hassanzadeh
 * @author Gustav Malm
 *
 */
@Entity(name="employees")
public class Employee implements Serializable {
	
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
	 * @return This Object's FirstName
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * 
	 * @param firstname Sets this Object's FirstName
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
	/**
	 * 
	 * @return This Object's Location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 
	 * @param lastname Sets this Object's Location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 
	 * @return This Object's Role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * 
	 * @param lastname Sets this Object's Role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * 
	 * @return This Object's RegistrationDate
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}
	/**
	 * 
	 * @param lastname Sets this Object's RegistrationDate
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", location=" + location
				+ ", role=" + role + ", registrationDate=" + registrationDate + "]";
	}
}
