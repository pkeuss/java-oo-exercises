package Blogz;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUser {
	
	User u = new User("thatGuy", "Pass");
	User u1 = new User("thatGuy", "Pass");
	User t = new User("huh23", "one1");
	Post p = new Post("String1", "String2", u.getUsername());

	

	@Test
	public void testIsValidPassword() {
		String pass = "one1";
		String notPass = "Something";
		assertTrue("IsValidPassword: True Statement 1", u.isValidPassword("Pass"));
		assertTrue("IsValidPassword: True Statement 2", t.isValidPassword(pass));
		assertFalse("IsValidPassword: False Statement 1", u.isValidPassword("blah"));
		assertFalse("IsValidPassword: False Statement 2", t.isValidPassword(notPass));
	}
	
	
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
		//Remember the objects are created for each test
		assertEquals("getUid: Test 1 is not working", u.getUid(), 29);
		assertEquals("getUid: Test 1 is not working", t.getUid(), 31);
	}
	
	@Test
	public void testEquals(){
		assertTrue("Equals: Test #1 true not working", u.equals(u1));
		assertTrue("Equals: Test #2 not working", u1.equals(u));
		assertFalse("Equals: Test false #1 is not working", u.equals(t));
		assertFalse("Equals: Test false #2 not working", t.equals(u1));
		//Test different classes not equal
		assertFalse("Equals Class: Test #1 not working", u.equals(p));
		assertFalse("Equals Class: Test #2 not working", p.equals(t));
		//Self Test
		assertTrue("Self Equals: Test #1 not working", u.equals(u));
		assertTrue("Self Equals: Test #2 not working", u1.equals(u1));
		assertTrue("Self Equals: Test #3 not working", t.equals(t));
		//Null check
		assertFalse("Null Equal: Test #1 not working", u.equals(null));
		assertFalse("Null Equal: Test #2 not working", t.equals(null));
	}

}
