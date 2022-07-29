package com.safetynet.safetynetalert.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.service.CommunityEmailService;

@SpringBootTest
public class CommunityEmailTest {
	
	@Autowired
	private CommunityEmailService communityEmail;
	
	@Test
	public void communityEmailTest() {
		
		String excepted = "[{\"email\":\"jaboyd@email.com\"},{\"email\":\"drk@email.com\"},{\"email\":\"tenz@email.com\"},{\"email\":\"jaboyd@email.com\"},{\"email\":\"jaboyd@email.com\"},{\"email\":\"drk@email.com\"},{\"email\":\"tenz@email.com\"},{\"email\":\"jaboyd@email.com\"},{\"email\":\"jaboyd@email.com\"},{\"email\":\"tcoop@ymail.com\"},{\"email\":\"lily@email.com\"},{\"email\":\"soph@email.com\"},{\"email\":\"ward@email.com\"},{\"email\":\"zarc@email.com\"},{\"email\":\"reg@email.com\"},{\"email\":\"jpeter@email.com\"},{\"email\":\"jpeter@email.com\"},{\"email\":\"aly@imail.com\"},{\"email\":\"bstel@email.com\"},{\"email\":\"ssanw@email.com\"},{\"email\":\"bstel@email.com\"},{\"email\":\"clivfd@ymail.com\"},{\"email\":\"gramps@email.com\"}]";
		
		List<Object> result = communityEmail.emailCity("Culver");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}

}
