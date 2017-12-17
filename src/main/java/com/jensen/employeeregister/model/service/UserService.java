package main.java.com.jensen.employeeregister.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.jensen.employeeregister.model.bean.User;
import main.java.com.jensen.employeeregister.model.repository.IUserRepository;

/**
 * A Service Layered Class which is interacting with the IIserRepository.class.
 * This Class deals with the more business-like code and forwards it to the IUserRepository.class
 * once passed.
 * 
 * @author Gustav Malm
 * @author Kami Hassanzadeh
 */
@Transactional
@Service
public class UserService implements IUserService {
	/**
	 * Autowired the IUserRepository.class in order to call methods from it.
	 */
	@Autowired
	private IUserRepository userRepository;
	/**
	 * Autowired the PasswordEncoder @Bean to be able to encrypt/encode the password if needed.
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;
	/**
	 * Method for obtaining single User with the assistance IUserRepository.class.
	 * 
	 * @return a User
	 */
	@Override
	public User findById(int id) {
		return this.userRepository.getUserById(id);
	}
	/**
	 * Method for obtaining single User with the assistance IUserRepository.class.
	 * 
	 * @return a User
	 */
	@Override
	public User findByUsername(String username) {
		
		return this.userRepository.getUserByUsername(username);
	}
	/**
	 * Method for adding a new Employee with the assistance IUserRepository.class.
	 * 
	 */
	@Override
	public void saveUser(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		this.userRepository.addUser(user);
	}
	/**
	 * Method for updating a single User with the assistance IUserRepository.class.
	 * 
	 */
	@Override
	public void updateUser(User user) {
		User entity = this.userRepository.getUserById(user.getId());
		if(entity != null) {
			entity.setUsername(user.getUsername());
			if(!user.getPassword().equals(entity.getPassword())); {
				entity.setPassword(this.passwordEncoder.encode(user.getPassword()));
			}
			entity.setUsername(user.getUsername());
		}
	}
	/**
	 * Method for removing a single User with the assistance IUserRepository.class.
	 * 
	 */
	@Override
	public void deleteUserByUsername(String username) {
		this.userRepository.deleteUserByUsername(username);
	}
	/**
	 * Method for obtaining a list of all Users with the assistance IUserRepository.class.
	 * 
	 * @return a list of all Users
	 */
	@Override
	public List<User> findAllUsers() {
		
		return this.userRepository.getAllUsers();
	}
	/**
	 * Method for checking if a Username does already exist or not.
	 * 
	 */
	@Override
	public boolean isUsernameUnique(Integer id, String username) {
		User user = this.findByUsername(username);
		
		return (user == null || ((id != null) && (user.getId()) == id));
	}
}