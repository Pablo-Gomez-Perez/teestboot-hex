package com.example.testboot.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.testboot.application.port.out.UserRepository;
import com.example.testboot.domain.User;

class UserServiceTest {

	private UserRepository userRepository;
	private UserService userService;
	
	@BeforeEach
	void setup() {
		this.userRepository = Mockito.mock(UserRepository.class);
		this.userService = new UserService(userRepository);
	}
	
	@Test
	void testGetUsers() {
		List<User> mockUsers = List.of(new User(1L, "John Doe", "john.doe@example.com"));
        when(userRepository.findAll()).thenReturn(mockUsers);

        List<User> users = userService.getAllUsers();

        assertEquals(1, users.size());
        assertEquals("John Doe", users.get(0).getName());
        verify(userRepository, times(1)).findAll(); // Verifica que se llamó al método `findAll`    
	}
	
	@Test
	void createUser() {
		
	}

}
