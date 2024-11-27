package com.example.testboot.application.port.out;

import java.util.List;

import com.example.testboot.domain.User;

public interface UserRepository {
	List<User> findAll();
	void save(User user);
}
