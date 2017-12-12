package main.java.com.jensen.employeeregister.model.repository;

import java.util.List;

import main.java.com.jensen.employeeregister.model.bean.User;


public interface IUserRepository {

	List<User> getAllUsers();

	User getUserById(int id);

	User getUserByUsername(String username);

	void addUser (User user);

	void updateUser (User user);

	void deleteUser(int id);
	
}
