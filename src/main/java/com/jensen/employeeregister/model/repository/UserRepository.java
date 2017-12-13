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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		
		String query = "FROM users";
		
		return (List<User>) this.hibernateTemplate.find(query);
	}

	@Override
	public User getUserById(int id) {
		
		return this.hibernateTemplate.get(User.class, id);
	}

	@Override
	public User getUserByUsername(String username) {
		for(User user : this.getAllUsers()) {
			if(user.getUsername().equals(username)) {
				return user;
			} 
		}
		return null;
	}

	@Override
	public void addUser(User user) {
		this.hibernateTemplate.save(user);
	}

	@Override
	public void updateUser(User user) {
		this.hibernateTemplate.update(user);
	}

	@Override
	public void deleteUserById(int id) {
		this.hibernateTemplate.delete(this.getUserById(id));
	}

	@Override
	public void deleteUserByUsername(String username) {
		User user = this.getUserByUsername(username);
		if(user != null) {
			this.hibernateTemplate.delete(user);
		}
	}

}
