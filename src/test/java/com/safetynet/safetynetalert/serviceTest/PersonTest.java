package com.safetynet.safetynetalert.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.domain.dtos.PersonCreate;
import com.safetynet.safetynetalert.service.PersonService;

@SpringBootTest
public class PersonTest {
	
	@Autowired
	private PersonService person;
	
	
	@Test
	public void createPersonTest() {
		
		String excepted = "[{\"zip\":\"97451\",\"firstName\":\"John\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"tenz@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6544\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"address\":\"29 15th St\",\"city\":\"Culver\",\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Tessa\",\"lastName\":\"Carman\",\"address\":\"834 Binoc Ave\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"tenz@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"address\":\"644 Gershwin Cir\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Foster\",\"lastName\":\"Shepard\",\"address\":\"748 Townings Dr\",\"city\":\"Culver\",\"phone\":\"841-874-6544\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Tony\",\"lastName\":\"Cooper\",\"address\":\"112 Steppes Pl\",\"city\":\"Culver\",\"phone\":\"841-874-6874\",\"email\":\"tcoop@ymail.com\"},{\"zip\":\"97451\",\"firstName\":\"Lily\",\"lastName\":\"Cooper\",\"address\":\"489 Manchester St\",\"city\":\"Culver\",\"phone\":\"841-874-9845\",\"email\":\"lily@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Sophia\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"phone\":\"841-874-7878\",\"email\":\"soph@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Warren\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"phone\":\"841-874-7512\",\"email\":\"ward@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Zach\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"phone\":\"841-874-7512\",\"email\":\"zarc@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"address\":\"908 73rd St\",\"city\":\"Culver\",\"phone\":\"841-874-8547\",\"email\":\"reg@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"address\":\"908 73rd St\",\"city\":\"Culver\",\"phone\":\"841-874-7462\",\"email\":\"jpeter@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Ron\",\"lastName\":\"Peters\",\"address\":\"112 Steppes Pl\",\"city\":\"Culver\",\"phone\":\"841-874-8888\",\"email\":\"jpeter@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Allison\",\"lastName\":\"Boyd\",\"address\":\"112 Steppes Pl\",\"city\":\"Culver\",\"phone\":\"841-874-9888\",\"email\":\"aly@imail.com\"},{\"zip\":\"97451\",\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"city\":\"Culver\",\"phone\":\"841-874-7784\",\"email\":\"bstel@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"city\":\"Culver\",\"phone\":\"841-874-7784\",\"email\":\"ssanw@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"city\":\"Culver\",\"phone\":\"841-874-7784\",\"email\":\"bstel@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Clive\",\"lastName\":\"Ferguson\",\"address\":\"748 Townings Dr\",\"city\":\"Culver\",\"phone\":\"841-874-6741\",\"email\":\"clivfd@ymail.com\"},{\"zip\":\"97451\",\"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"address\":\"951 LoneTree Rd\",\"city\":\"Culver\",\"phone\":\"841-874-7458\",\"email\":\"gramps@email.com\"},{\"firstName\":\"J\",\"lastName\":\"B\",\"address\":\"sdfgdsfgsdfg\",\"city\":\"sdgffdsgdd\",\"zip\":\"11111\",\"phone\":\"4254254254254\",\"email\":\"sdfgdsgdgs@email.com\"}]";
		
		PersonCreate entity = new PersonCreate();
		
		entity.setFirstName("J");
		entity.setLastName("B");
		entity.setAddress("sdfgdsfgsdfg");
		entity.setCity("sdgffdsgdd");
		entity.setZip("11111");
		entity.setPhone("4254254254254");
		entity.setEmail("sdfgdsgdgs@email.com");
		
		JSONArray result = person.createPerson(entity);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
		
	}
	
	@Test
	public void getPersonTest() {
		
		String excepted = "{\"zip\":\"97451\",\"firstName\":\"John\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"}";
		
		JSONObject result = (JSONObject) person.getPerson("John", "Boyd");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
		
	}
	
	@Test
	public void updatePersonTest() {
		
		String excepted = "[{\"zip\":\"11111\",\"firstName\":\"John\",\"lastName\":\"Boyd\",\"address\":\"sdfgdsfgsdfg\",\"city\":\"sdgffdsgdd\",\"phone\":\"4254254254254\",\"email\":\"sdfgdsgdgs@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"tenz@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6544\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"address\":\"29 15th St\",\"city\":\"Culver\",\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Tessa\",\"lastName\":\"Carman\",\"address\":\"834 Binoc Ave\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"tenz@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"address\":\"644 Gershwin Cir\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Foster\",\"lastName\":\"Shepard\",\"address\":\"748 Townings Dr\",\"city\":\"Culver\",\"phone\":\"841-874-6544\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Tony\",\"lastName\":\"Cooper\",\"address\":\"112 Steppes Pl\",\"city\":\"Culver\",\"phone\":\"841-874-6874\",\"email\":\"tcoop@ymail.com\"},{\"zip\":\"97451\",\"firstName\":\"Lily\",\"lastName\":\"Cooper\",\"address\":\"489 Manchester St\",\"city\":\"Culver\",\"phone\":\"841-874-9845\",\"email\":\"lily@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Sophia\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"phone\":\"841-874-7878\",\"email\":\"soph@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Warren\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"phone\":\"841-874-7512\",\"email\":\"ward@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Zach\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"phone\":\"841-874-7512\",\"email\":\"zarc@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"address\":\"908 73rd St\",\"city\":\"Culver\",\"phone\":\"841-874-8547\",\"email\":\"reg@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"address\":\"908 73rd St\",\"city\":\"Culver\",\"phone\":\"841-874-7462\",\"email\":\"jpeter@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Ron\",\"lastName\":\"Peters\",\"address\":\"112 Steppes Pl\",\"city\":\"Culver\",\"phone\":\"841-874-8888\",\"email\":\"jpeter@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Allison\",\"lastName\":\"Boyd\",\"address\":\"112 Steppes Pl\",\"city\":\"Culver\",\"phone\":\"841-874-9888\",\"email\":\"aly@imail.com\"},{\"zip\":\"97451\",\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"city\":\"Culver\",\"phone\":\"841-874-7784\",\"email\":\"bstel@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"city\":\"Culver\",\"phone\":\"841-874-7784\",\"email\":\"ssanw@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"city\":\"Culver\",\"phone\":\"841-874-7784\",\"email\":\"bstel@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Clive\",\"lastName\":\"Ferguson\",\"address\":\"748 Townings Dr\",\"city\":\"Culver\",\"phone\":\"841-874-6741\",\"email\":\"clivfd@ymail.com\"},{\"zip\":\"97451\",\"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"address\":\"951 LoneTree Rd\",\"city\":\"Culver\",\"phone\":\"841-874-7458\",\"email\":\"gramps@email.com\"}]";
		
		PersonCreate entity = new PersonCreate();
		
		entity.setAddress("sdfgdsfgsdfg");
		entity.setCity("sdgffdsgdd");
		entity.setZip("11111");
		entity.setPhone("4254254254254");
		entity.setEmail("sdfgdsgdgs@email.com");
		
		JSONArray result = person.updatePerson("John", "Boyd", entity);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
		
	}
	
	@Test
	public void deletePersonTest() {
		
		String excepted = "[{\"zip\":\"97451\",\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"tenz@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"phone\":\"841-874-6544\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"address\":\"29 15th St\",\"city\":\"Culver\",\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Tessa\",\"lastName\":\"Carman\",\"address\":\"834 Binoc Ave\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"tenz@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"address\":\"644 Gershwin Cir\",\"city\":\"Culver\",\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Foster\",\"lastName\":\"Shepard\",\"address\":\"748 Townings Dr\",\"city\":\"Culver\",\"phone\":\"841-874-6544\",\"email\":\"jaboyd@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Tony\",\"lastName\":\"Cooper\",\"address\":\"112 Steppes Pl\",\"city\":\"Culver\",\"phone\":\"841-874-6874\",\"email\":\"tcoop@ymail.com\"},{\"zip\":\"97451\",\"firstName\":\"Lily\",\"lastName\":\"Cooper\",\"address\":\"489 Manchester St\",\"city\":\"Culver\",\"phone\":\"841-874-9845\",\"email\":\"lily@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Sophia\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"phone\":\"841-874-7878\",\"email\":\"soph@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Warren\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"phone\":\"841-874-7512\",\"email\":\"ward@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Zach\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"phone\":\"841-874-7512\",\"email\":\"zarc@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"address\":\"908 73rd St\",\"city\":\"Culver\",\"phone\":\"841-874-8547\",\"email\":\"reg@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"address\":\"908 73rd St\",\"city\":\"Culver\",\"phone\":\"841-874-7462\",\"email\":\"jpeter@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Ron\",\"lastName\":\"Peters\",\"address\":\"112 Steppes Pl\",\"city\":\"Culver\",\"phone\":\"841-874-8888\",\"email\":\"jpeter@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Allison\",\"lastName\":\"Boyd\",\"address\":\"112 Steppes Pl\",\"city\":\"Culver\",\"phone\":\"841-874-9888\",\"email\":\"aly@imail.com\"},{\"zip\":\"97451\",\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"city\":\"Culver\",\"phone\":\"841-874-7784\",\"email\":\"bstel@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"city\":\"Culver\",\"phone\":\"841-874-7784\",\"email\":\"ssanw@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"city\":\"Culver\",\"phone\":\"841-874-7784\",\"email\":\"bstel@email.com\"},{\"zip\":\"97451\",\"firstName\":\"Clive\",\"lastName\":\"Ferguson\",\"address\":\"748 Townings Dr\",\"city\":\"Culver\",\"phone\":\"841-874-6741\",\"email\":\"clivfd@ymail.com\"},{\"zip\":\"97451\",\"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"address\":\"951 LoneTree Rd\",\"city\":\"Culver\",\"phone\":\"841-874-7458\",\"email\":\"gramps@email.com\"}]";
		
		JSONArray result = person.deletePerson("John", "Boyd");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
		
	}

}
