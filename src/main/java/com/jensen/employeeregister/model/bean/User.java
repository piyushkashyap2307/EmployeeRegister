package main.java.com.jensen.employeeregister.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="users")
public class User implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7959324777091864065L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@NotNull
	@Column(name = "username")
	@Size(min = 2, max = 22)
	private String username;
	
	@NotNull
	@Column(name = "password")
	@Size(min = 3, max = 22)
	private String password;
	
	private boolean isSignedIn;

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSignedIn() {
		return isSignedIn;
	}

	public void setSignedIn(boolean isSignedIn) {
		this.isSignedIn = isSignedIn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + username + ", password=" + password + ", isSignedIn=" + isSignedIn
				+ "]";
	}
	

}
