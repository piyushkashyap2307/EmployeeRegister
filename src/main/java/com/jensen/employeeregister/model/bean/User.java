package main.java.com.jensen.employeeregister.model.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
/**
 * 
 * This Class is the EntityType of a User
 * 
 * @author Kami Hassanzadeh
 * @author Gustav Malm
 *
 */
@Entity(name="users")
public class User implements Serializable{
	
	private static final long serialVersionUID = -7959324777091864065L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "password")
	private String password;

	private boolean isSignedIn;
	/**
	 * Default Constructor of the User.class
	 */
	public User() {
	}
	/**
	 * 
	 * @return This Object's Username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 
	 * @return This Object's set Of Username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 
	 * @return This Object's Password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @return This Object's set Of Password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return This Object's IsSignedIn
	 */
	public boolean isSignedIn() {
		return isSignedIn;
	}
	/**
	 * 
	 * @return This Object's set Of IsSignedIn
	 */
	public void setSignedIn(boolean isSignedIn) {
		this.isSignedIn = isSignedIn;
	}
	/**
	 * 
	 * @return This Object's Id
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @return This Object's set Of Id
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + username + ", password=" + password + ", isSignedIn=" + isSignedIn
				+ "]";
	}
	

}
