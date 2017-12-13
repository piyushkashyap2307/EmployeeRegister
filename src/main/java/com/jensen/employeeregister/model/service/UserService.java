package main.java.com.jensen.employeeregister.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.jensen.employeeregister.model.bean.User;
import main.java.com.jensen.employeeregister.model.repository.IUserRepository;

@Transactional
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User findById(int id) {
		return this.userRepository.getUserById(id);
	}

	@Override
	public User findByUsername(String username) {
		
		return this.userRepository.getUserByUsername(username);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		this.userRepository.addUser(user);
	}

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

	@Override
	public void deleteUserByUsername(String username) {
		this.userRepository.deleteUserByUsername(username);
	}

	@Override
	public List<User> findAllUsers() {
		
		return this.userRepository.getAllUsers();
	}

	@Override
	public boolean isUserUsernameUnique(Integer id, String username) {
		User user = this.findByUsername(username);
		
		return (user == null || ((id != null) && (user.getId()) == id));
	}

}
