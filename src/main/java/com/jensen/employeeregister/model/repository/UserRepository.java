package main.java.com.jensen.employeeregister.model.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import main.java.com.jensen.employeeregister.model.bean.User;

@Transactional
@Repository
public class UserRepository implements IUserRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	/**
	 * Method for obtaining a list of all Userss with the assistance of the HibernateTemplate.
	 * 
	 * @return a list of all Users
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String query = "FROM users";
		
		return (List<User>) this.hibernateTemplate.find(query);
	}
	/**
	 * Method for obtaining a User based on the id value passed through as a parameter.
	 * 
	 * @return a User with the specific id value
	 */
	@Override
	public User getUserById(int id) {
		
		return this.hibernateTemplate.get(User.class, id);
	}
	/**
	 * Method for obtaining a User based on the id value passed through as a parameter.
	 * 
	 * @return a User with the specific username value
	 */
	@Override
	public User getUserByUsername(String username) {
		for(User user : this.getAllUsers()) {
			if(user.getUsername().equals(username)) {
				return user;
			} 
		}
		return null;
	}
	/**
	 * Method for adding a User based on the User Object passing through as a parameter.
	 * 
	 */
	@Override
	public void addUser(User user) {
		this.hibernateTemplate.save(user);
	}
	/**
	 * Method for updating a User based on the User Object passing through as a parameter.
	 * 
	 */
	@Override
	public void updateUser(User user) {
		this.hibernateTemplate.update(user);
	}
	/**
	 * Method for removing a User based on the id value passing through as a parameter.
	 * 
	 */
	@Override
	public void deleteUserById(int id) {
		this.hibernateTemplate.delete(this.getUserById(id));
	}
	/**
	 * Method for removing a User based on the username value passing through as a parameter.
	 * 
	 */
	@Override
	public void deleteUserByUsername(String username) {
		User user = this.getUserByUsername(username);
		if(user != null) {
			this.hibernateTemplate.delete(user);
		}
	}
}