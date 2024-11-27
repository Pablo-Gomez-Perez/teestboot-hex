package com.example.testboot.adapters.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testboot.application.port.in.CreateUserUseCase;
import com.example.testboot.application.port.in.GetUsersUseCase;
import com.example.testboot.domain.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final GetUsersUseCase getUsersUseCase;
    private final CreateUserUseCase createUserUseCase;
    
	public UserController(GetUsersUseCase getUsersUseCase, CreateUserUseCase createUserUseCase) {
		super();
		this.getUsersUseCase = getUsersUseCase;
		this.createUserUseCase = createUserUseCase;
	}
    
	
	@GetMapping
	public List<User> getAllUsers(){
		return getUsersUseCase.getAllUsers();
	}
	
	@PostMapping
	public void createUser(@RequestBody UserDto userDto) {
		createUserUseCase.createUser(userDto.name(), userDto.email());
	}
	
}

record UserDto(String name, String email) {}