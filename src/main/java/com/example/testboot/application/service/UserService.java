package com.example.testboot.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testboot.application.port.in.CreateUserUseCase;
import com.example.testboot.application.port.in.GetUsersUseCase;
import com.example.testboot.application.port.out.UserRepository;
import com.example.testboot.domain.User;

@Service
public class UserService implements GetUsersUseCase, CreateUserUseCase {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void createUser(String name, String email) {
		// return userRepository.findAll();
		User user = new User(null, name, email);
        userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
