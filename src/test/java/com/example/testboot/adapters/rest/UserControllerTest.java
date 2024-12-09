package com.example.testboot.adapters.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.testboot.application.port.in.CreateUserUseCase;
import com.example.testboot.application.port.in.GetUsersUseCase;
import com.example.testboot.domain.User;

@WebMvcTest(UserController.class)
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private CreateUserUseCase createUseruseCase;

	@MockitoBean
	private GetUsersUseCase getUseruseCase;

	@Test
	void testGetAllUsers() throws Exception {

		List<User> mockUsers = List.of(new User(null, "Marcus Finix", "finix_cgo@mail.com"));
		when(getUseruseCase.getAllUsers()).thenReturn(mockUsers);

		mockMvc.perform(get("/users"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()").value(1))
			.andExpect(jsonPath("$[0].name").value("Marcus Finix"));

		verify(getUseruseCase, times(1)).getAllUsers();

	}

	@Test
	void testCreateUser() throws Exception {

		mockMvc.perform(post("/users").contentType("application/json").content("""
				{
				    "name": "Marcus finix",
				    "email": "finix_cgo@mail.com"
				}
				""")).andExpect(status().isOk());

		verify(createUseruseCase, times(1)).createUser("Marcus finix", "finix_cgo@mail.com");

	}

}
