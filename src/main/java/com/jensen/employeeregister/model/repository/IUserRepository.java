package main.java.com.jensen.employeeregister.model.repository;

import java.util.List;

import main.java.com.jensen.employeeregister.model.bean.User;

/**
 * An Interface for the UserRepository.class
 * 
 */
public interface IUserRepository {

	List<User> getAllUsers();

	User getUserById(int id);

	User getUserByUsername(String username);

	void addUser (User user);

	void updateUser (User user);

	void deleteUserById(int id);
	
	void deleteUserByUsername(String username);
	
}
