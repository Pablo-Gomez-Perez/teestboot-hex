package com.example.testboot.adapters.persistance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.testboot.application.port.out.UserRepository;
import com.example.testboot.domain.User;

@Component
public class InMemoryUserRepository implements UserRepository {

	private final List<User> users = new ArrayList<>();
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(users);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		users.add(new User((long) (users.size() + 1), user.getName(), user.getEmail()));
	}

}
