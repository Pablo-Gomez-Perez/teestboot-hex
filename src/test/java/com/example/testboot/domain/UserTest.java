package com.example.testboot.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testCreatedUser() {
		
		User user = new User(1L,"Marcus Finix","finix_cog@mail.com");
		
		assertEquals(1L, user.getId());
		assertEquals("Marcus Finix", user.getName());
		assertEquals("finix_cog@mail.com", user.getEmail());
		
	}
	
	@Test
	void testNullUserValues() {
		
		User user = new User(null,"Marcus Finix","finix_cog@mail.com");
		
		assertNull(user.getId());
		assertEquals("Marcus Finix", user.getName());
		assertEquals("finix_cog@mail.com", user.getEmail());		
		
	}

}
