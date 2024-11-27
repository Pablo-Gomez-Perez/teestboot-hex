package com.example.testboot.application.port.in;

import java.util.List;

import com.example.testboot.domain.User;

public interface GetUsersUseCase {
	List<User> getAllUsers();
}
