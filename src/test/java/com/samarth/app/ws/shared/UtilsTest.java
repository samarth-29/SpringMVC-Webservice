package com.samarth.app.ws.shared;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UtilsTest {

	@Autowired
	Utils utils;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGenerateUserId() {
		
		String userId = utils.generateUserId(30);
		String userId2 = utils.generateUserId(30);
		
		assertNotNull(userId);
		assertNotNull(userId2);
		
		assertTrue(userId.length() == 30);
		assertTrue(!userId.equalsIgnoreCase(userId2));
	}

	@Test
	void testHasTokenNotExpired() {
		
		String token = utils.generateEmailVerificationToken("4yr65hhyid84");
		assertNotNull(token);
		
		boolean hasTokenExpired = Utils.hasTokenExpired(token);
		
		assertFalse(hasTokenExpired);
		
	}
	
	@Test
	final void testHasTokenExpired()
	{
		String expiredToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrQHlhaG9vLmNvbSIsImV4cCI6MTU1ODczMTg5MX0.Hi0_CjuRvontxo2qnTfVUHFSdTPEA9AuTZ_2_ZwXeihDp_cE7BZdT1amgaFZcSxS4MZ71aNEbSVLwaMYkKHFGA";
		boolean hasTokenExpired = Utils.hasTokenExpired(expiredToken);
		
		assertTrue(hasTokenExpired);
	}
}
