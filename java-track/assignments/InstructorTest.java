import static org.junit.Assert.*;

import org.junit.Test;

public class InstructorTest {

	@Test
	public void testInstructor() {
		Instructor i = new Instructor("Paul", "Smith");
		assertEquals("Constructor: first name problem", "Paul", i.getFirstName());
		assertEquals("Constructor: last name problem", "Smith", i.getLastName());
		assertEquals("Constructor: full name problem", "Paul Smith", i.getFullName());
		assertEquals("Constructor: file name problem", "Smith, Paul", i.getFileName());
	}
	
	
	@Test
	public void testTenure() {
		Instructor i = new Instructor("Paul", "Smith");
		assertEquals("Tenure: initial tenure is wrong", false, i.isTenure());
		i.setTenure();
		assertEquals("Tenure: setting tenure to true is wrong", true, i.isTenure());
		i.setTenure();
		assertEquals("Tenure: setting tenure back to false is wrong", false, i.isTenure());
	}
	
	
	@Test
	public void testProfessor() {
		Instructor i = new Instructor("Paul", "Smith");
		assertEquals("Professor: initial Professor is wrong", false, i.isProfessor());
		i.setProfessor();
		assertEquals("Professor: setting Professor to true is wrong", true, i.isProfessor());
		i.setProfessor();
		assertEquals("Professor: setting Professor back to false is wrong", false, i.isProfessor());
	}
	
	
	@Test
	public void testSalary() {
		Instructor i = new Instructor("Paul", "Smith");
		double newSalary = 500000.00;
		assertEquals("Salary: initial Salary is wrong", 20000.00, i.getSalary(), 0.01);
		i.setSalary(120000.00);
		assertEquals("Salary: setting Salary to 120000.00 is wrong", 120000.00, i.getSalary(), 0.01);
		i.setSalary(newSalary);
		assertEquals("Salary: setting Salary by variable is wrong", 500000.00, i.getSalary(), 0.01);
	}
	
	
	@Test
	public void testYearsOfService() {
		Instructor i = new Instructor("Paul", "Smith");
		int newYear = 12;
		assertEquals("YearsOfService: initial YearsOfService is wrong", 0, i.getYearsOfService());
		i.setYearsOfService(4);
		assertEquals("YearsOfService: setting YearsOfService to 120000.00 is wrong", 4, i.getYearsOfService());
		i.setYearsOfService(newYear);
		assertEquals("YearsOfService: setting YearsOfService by variable is wrong", 12, i.getYearsOfService());
		i.addYear();
		assertEquals("YearsOfService: addYear() method by variable is wrong", 13, i.getYearsOfService());
	}
	
	
	@Test
	public void testAddCourse() {
		for (int i = 0; i < 100; i++) {
			double fname = (Math.random() * 5000);
			double lname = (Math.random() * 5000);
			Instructor instruct = new Instructor("P" + fname, "S" + lname);

			for (int j = 0; j < 7; j++) {
				double a =  (Math.random() * 5000);
				int s = (int)(Math.random() * 50);
				Course c = new Course("" + a, s, s);
				boolean added = instruct.addCourse(c);
				assertTrue("addCourse not working properly", added);
			}

			//Try to add courses, even though the semester is full.
			for (int j = 0; j < 7; j++) {
				double aa =  (Math.random() * 5000);
				int ss = (int)(Math.random() * 50);
				Course c1 = new Course("" + aa, ss, ss);
				boolean added = instruct.addCourse(c1);

				assertTrue("addCourse not working properly: course added even though semester was full", !added);
			}
		}
	}
	
	
	
	@Test
	public void testGenerateCourseList() {
		
		Instructor i = new Instructor("P", "S");
		Course c0 = new Course("c0", 1, 2);
		i.addCourse(c0);
		Course c1 = new Course("c1", 1, 2);
		i.addCourse(c1);
		Course c2 = new Course("c2", 1, 2);
		i.addCourse(c2);
		Course c3 = new Course("c3", 1, 2);
		i.addCourse(c3);
		Course c4 = new Course("c4", 1, 2);
		i.addCourse(c4);
		Course c5 = new Course("c5", 1, 2);
		i.addCourse(c5);
		Course c6 = new Course("c6", 1, 2);
		i.addCourse(c6);
		
		assertTrue("generateCourseList: not working, c0", i.generateCourseList().contains("c0"));
		assertTrue("generateCourseList: not working, c1", i.generateCourseList().contains("c1"));
		assertTrue("generateCourseList: not working, c2", i.generateCourseList().contains("c2"));
		assertTrue("generateCourseList: not working, c3", i.generateCourseList().contains("c3"));
		assertTrue("generateCourseList: not working, c4", i.generateCourseList().contains("c4"));
		assertTrue("generateCourseList: not working, c5", i.generateCourseList().contains("c5"));
		assertTrue("generateCourseList: not working, c6", i.generateCourseList().contains("c6"));
	}
	
	
	
	@Test
	public void testResetCourseList() {
		
		Instructor i = new Instructor("P", "S");
		Course c0 = new Course("c0", 1, 2);
		i.addCourse(c0);
		Course c1 = new Course("c1", 1, 2);
		i.addCourse(c1);
		Course c2 = new Course("c2", 1, 2);
		i.addCourse(c2);
		Course c3 = new Course("c3", 1, 2);
		i.addCourse(c3);
		Course c4 = new Course("c4", 1, 2);
		i.addCourse(c4);
		Course c5 = new Course("c5", 1, 2);
		i.addCourse(c5);
		Course c6 = new Course("c6", 1, 2);
		i.addCourse(c6);
		
		//Briefly check for added courses before resetting
		assertTrue("restCourseList: not working, c6", i.generateCourseList().contains("c6"));
		assertTrue("resetCourseList: not working, c3", i.generateCourseList().contains("c3"));
		
		i.resetCourseList();
		assertEquals("resetCourseList: not working, null/empty String", i.generateCourseList(), "");
	}

}
