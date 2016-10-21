package Blogz;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestPost {
	
	User u = new User("user1", "password");
	User t = new User("user2", "password");
	Post p = new Post("Here is the body for this post", "Title1", u.getUsername());
	Post q = new Post("Here is the body for this post, also, too", "Title2", t.getUsername());
	Date ddd = new Date();

	@Test
	public void testPost() {
		assertEquals("Post() Test 1 is not working", p.getAuthor(), u.getUsername());
		assertEquals("Post() Test 2 is not working", q.getAuthor(), t.getUsername());
		assertEquals("Post() Test 3 is not working", p.getBody(), "Here is the body for this post");
		assertEquals("Post() Test 4 is not working", q.getBody(), "Here is the body for this post, also, too");
		assertEquals("Post() Test 5 is not working", p.getTitle(), "Title1");
		assertEquals("Post() Test 6 is not working", q.getTitle(), "Title2");
	}

	@Test
	public void testGetBody() {
		assertEquals("GetBody() Test 1 is not working", p.getBody(), "Here is the body for this post");
		assertEquals("GetBody() Test 2 is not working", q.getBody(), "Here is the body for this post, also, too");
	}

	@Test
	public void testSetBody() {
		p.setBody("I changed this, to test it");
		q.setBody("What!");
		assertEquals("SetBody() Test 1 is not working", p.getBody(), "I changed this, to test it");
		assertEquals("SetBody() Test 2 is not working", q.getBody(), "What!");
		p.setBody("Here is the body for this post");
		q.setBody("Here is the body for this post, also, too");
		assertEquals("SetBody() Test 3 is not working", p.getBody(), "Here is the body for this post");
		assertEquals("SetBody() Test 4 is not working", q.getBody(), "Here is the body for this post, also, too");
	}

	@Test
	public void testGetTitle() {
		assertEquals("GetTitle() Test 1 is not working", p.getTitle(), "Title1");
		assertEquals("GetTitle() Test 2 is not working", q.getTitle(), "Title2");
	}

	@Test
	public void testSetTitle() {
		p.setTitle("A new Title!");
		q.setTitle("Wow!!!!!");
		assertEquals("GetTitle() Test 1 is not working", p.getTitle(), "A new Title!");
		assertEquals("GetTitle() Test 2 is not working", q.getTitle(), "Wow!!!!!");
	}

	@Test
	public void testGetUpdated() {
		Date d = new Date();
		Date dd = new Date();
		p.setUpdated(d);
		q.setUpdated(dd);
		assertEquals("getUpdated: Test 1 failed", p.getUpdated(), d);
		assertEquals("getUpdated: Test 2 failed", q.getUpdated(), dd);
	}

	@Test
	public void testSetUpdated() {
		Date d = new Date();
		Date dd = new Date();
		p.setUpdated(d);
		q.setUpdated(dd);
		assertEquals("setUpdated: Test 1 failed", p.getUpdated(), d);
		assertEquals("setUpdated: Test 2 failed", q.getUpdated(), dd);
	}

	@Test
	public void testGetAuthor() {
		assertEquals("Post() Test 1 is not working", p.getAuthor(), u.getUsername());
		assertEquals("Post() Test 2 is not working", q.getAuthor(), t.getUsername());
	}

	@Test
	public void testGetCreated() {
		assertEquals("getCreated: Test 1 failed", p.getCreated(), ddd);
		assertEquals("getCreated: Test 2 failed", q.getCreated(), ddd);
	}

	@Test
	public void testGetUid() {
		//will this change each time i turn off my computer??
		//assertEquals("getUid: Test 1 is not working", p.getUid(), 3);
		assertEquals("getUid: Test 2 is not working", q.getUid(), 28);
	}

}
