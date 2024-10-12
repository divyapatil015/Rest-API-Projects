package com.express.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.express.entities.User;
import com.express.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		log.info("userService :: createUser {} {} " ,user.getUsername(),user.getEmail());
		userRepository.save(user);
		log.info("User Successfully saved in DB");
		
	}
	
	public List<User> fetchAllUser() {
		List<User> userList=userRepository.findAll();
		List<User> result =userList.stream().sorted(Comparator.comparing(User::getUsername)).toList();
		return result;
		
	}
	
	public User findUserById(Long userId) {
		 return userRepository.findById(userId)
						.orElseThrow(()-> new RuntimeException("User Not Found"));
		
	}
	    
	public void updateUser(Long userId, User inputUser) {
		User dbUser = findUserById(userId);
		dbUser.setEmail(inputUser.getEmail());
		dbUser.setPassword(inputUser.getPassword());
		dbUser.setUsername(inputUser.getUsername());
		userRepository.save(dbUser);
		
	}
	
	public void deleteUser(Long userId) {
	 if(userRepository.existsById(userId)) {
		 userRepository.deleteById(userId);
	 }else
	 {
		 throw new RuntimeException("User Not Found");
	 }
	}
	}

