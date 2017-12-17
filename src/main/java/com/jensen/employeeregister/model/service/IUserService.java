package main.java.com.jensen.employeeregister.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import main.java.com.jensen.employeeregister.model.bean.User;
/**
 * An Interface for the UserService.class
 */
@Service
public interface IUserService {

	User findById(int id);
    
    User findByUsername(String username);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserByUsername(String username);
 
    List<User> findAllUsers(); 
     
    boolean isUsernameUnique(Integer id, String username);
	
}
