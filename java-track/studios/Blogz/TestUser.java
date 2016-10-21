package Blogz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestUser {
	
	User u = new User("thatGuy", "Pass");
	User t = new User("huh23", "one1");

	

	@Test
	public void testIsValidPassword() {
		String pass = "one1";
		String notPass = "Something";
		assertTrue("IsValidPassword: True Statement 1", u.isValidPassword("Pass"));
		assertTrue("IsValidPassword: True Statement 2", t.isValidPassword(pass));
		assertFalse("IsValidPassword: False Statement 1", u.isValidPassword("blah"));
		assertFalse("IsValidPassword: False Statement 2", t.isValidPassword(notPass));
	}
	
	/*
	 * The Users u and t don't exist for subsequent tests after the first one, why?
	 * I get a null pointer exception if i don't create them
	 */
	@Test
	public void testToString() {
		assertTrue("ToString: Test 1 is not working", u.toString().contains("thatGuy"));
		assertTrue("ToString: Test 2 is not working", t.toString().contains("huh23"));
	}

	@Test
	public void testGetUsername() {
		assertTrue("getUsername: Test 1 is not working", u.getUsername().contains("thatGuy"));
		assertTrue("getUsername: Test 2 is not working", t.getUsername().contains("huh23"));
	}

	@Test
	public void testSetUsername() {
		u.setUsername("guyThat");
		t.setUsername("huh20");
		assertTrue("setUserName: Test 1 is not working", u.getUsername().contains("guyThat"));
		assertTrue("setUsername: Test 2 is not working", t.getUsername().contains("huh20"));
		u.setUsername("thatGuy");
		t.setUsername("huh23");
		assertTrue("setUserName: Test 3 is not working", u.getUsername().contains("thatGuy"));
		assertTrue("setUsername: Test 4 is not working", t.getUsername().contains("huh23"));
	}

	@Test
	public void testGetAllUsers() {
		assertTrue("getAllUsers: Test 1 is not working", User.getAllUsers().contains(u));
		assertTrue("getAllUsers: Test 2 is not working", User.getAllUsers().contains(t));
	}

	@Test(expected = Exception.class)
	public void testIsValidUsernameFalse() {
		assertFalse("validUsername: Test 1 is not working", User.isValidUsername("huh"));
	}
	
	@Test
	public void testIsValidUsernameTrue() {
		assertTrue("validUsername: Test 2 is not working", User.isValidUsername("huh23"));
	}

	@Test
	public void testGetUid() {
		//this is the 11th  and 12th User that has been created during this junit test
		//so this changes a lot what can i do to actually test it within a Junit
		assertEquals("getUid: Test 1 is not working", u.getUid(), 11);
		assertEquals("getUid: Test 1 is not working", t.getUid(), 12);
	}

}
