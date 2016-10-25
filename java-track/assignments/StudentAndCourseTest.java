/*<<<<<<< HEAD

import static org.junit.Assert.*;

=======
>>>>>>> refs/remotes/launchcode/master
*/
import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class StudentAndCourseTest extends TestCase {

	String s1 = "either your getName() method isn't doing its job or you're not " +
			"setting your instance variables properly";
	String s2 = "either your getGPA() method is not doing its job or you're not " +
			"setting your instance variables properly";
	String s4 = "either your getCredits() method is not doing its job or you're not " +
			"setting your instance variables properly";
	String s5 = "either your getClassStanding() method isn't doing its job or you're not " +
			"setting your instance variables properly";
	String s6 = "The plus method shouldn't change the original vector";
	String s8 = "hasHigherAverage() isn't working properly";
	String s9 = "getClassStanding() isn't working properly";
	@Test
	public void testStudentInit() {
		Student s = new Student("Doug", "Shook", 111111);
		assertEquals("Doug Shook", s.getName());
		assertEquals(111111, s.getStudentID());
		//No credits, should be a freshman, no GPA
		assertEquals(0.0, s.getGPA());
		assertEquals(0, s.getCredits());
		assertEquals("Freshman", s.getClassStanding());
		for (int i = 0; i < 20; ++i) {
			double a =  (Math.random() * 5000);
			double b =  (Math.random() * 5000);
			int c = (int)(Math.random() * 5000);
			Student s3 = new Student("" + a, "" + b, c);
			assertEquals(s1, a + " " + b, s3.getName());
			assertEquals(s2, 0.0, s3.getGPA());
			assertEquals(s4, 0, s3.getCredits());
			assertEquals(s5, "Freshman", s3.getClassStanding());
		}
	}

	@Test
	public void testGetClassStanding() {
		Student s = new Student("D", "S", 1);
		for (int i = 0; i < 29; i++) {
			s.submitGrade(1.0, 1);
			assertEquals(s9, "Freshman", s.getClassStanding());
		}

		for (int i = 0; i < 30; i++) {
			s.submitGrade(1.0, 1);
			assertEquals(s9, "Sophomore", s.getClassStanding());
		}

		for (int i = 0; i < 30; i++) {
			s.submitGrade(1.0, 1);
			assertEquals(s9, "Junior", s.getClassStanding());
		}

		for (int i = 0; i < 30; i++) {
			s.submitGrade(1.0, 1);
			assertEquals(s9, "Senior", s.getClassStanding());
		}

	}

	@Test
	public void testSubmitGrade() {
		Student s = new Student("D", "S", 1);
		int credits = 0;
		double gpatotal = 0;
		for (int i = 0; i < 100; i++) {
			int c = (int)(Math.random() * 3 + 1);//1 to 3 credits
			double g = Math.random() * 4;//0 to 4
			credits += c;
			gpatotal += g * c;
			s.submitGrade(g, c);
			assertEquals("GPA computed incorrectly", gpatotal / credits, s.getGPA(), 0.01);
			assertTrue("GPA not rounded", (s.getGPA() + "").length() < 6);
		}
	}

	@Test
	public void testComputeTuition() {
		Student s = new Student("D", "S", 1);
		for (int i = 0; i < 14; i++) {
			s.submitGrade(0, 1);
			assertEquals("Compute tution not working properly", (i+1) * 1333.33, s.computeTuition());
		}

		s.submitGrade(0, 1);
		assertEquals("Compute tution not working properly", 20000.0, s.computeTuition());

		for (int i = 0; i < 14; i++) {
			s.submitGrade(0, 1);
			assertEquals("Compute tution not working properly", 1333.33 * (i+1) + 20000.0, s.computeTuition());
		}
	}

	@Test
	public void testCreateLegacy() {
		for(int i = 0; i < 100; i++) {
			double a =  (Math.random() * 5000);
			double b =  (Math.random() * 5000);
			Student s = new Student("" + a, "" + b, 1);
			double a2 =  (Math.random() * 5000);
			double b2 =  (Math.random() * 5000);
			Student ss = new Student("" + a2, "" + b2, 2);
			int c = (int)(Math.random() * 120 + 1);
			double g = Math.round(Math.random() * 4000) / 1000.0;
			s.submitGrade(g, c);
			int c2 = (int)(Math.random() * 120 + 1);
			double g2 = Math.round(Math.random() * 4000) / 1000.0;
			ss.submitGrade(g2, c2);
			Student bb = Student.createLegacy(s, ss);
			assertTrue("create baby not setting name properly", bb.getName().contains(s.getName()) && bb.getName().contains(ss.getName()));
			assertEquals("create baby not setting gpa properly", (g + g2) / 2, bb.getGPA(), 0.01);
			assertEquals("create baby not setting credits properly", bb.getCredits(), Math.max(c, c2));
			assertTrue("create baby not creating ID properly", bb.getStudentID() == s.getStudentID() + ss.getStudentID());

			//Make sure parents haven't changed
			assertEquals("createBaby should not alter the parents", a + " " + b, s.getName());
			assertEquals("createBaby should not alter the parents", g, s.getGPA());
			assertEquals("createBaby should not alter the parents", c, s.getCredits());

			assertEquals("createBaby should not alter the parents", a2 + " " + b2, ss.getName());
			assertEquals("createBaby should not alter the parents", g2, ss.getGPA());
			assertEquals("createBaby should not alter the parents", c2, ss.getCredits());

		}
	}

	@Test
	public void testStudentToString() {
		for (int i = 0; i < 100; i++) {
			double a =  (Math.random() * 5000);
			double b =  (Math.random() * 5000);
			int c = (int)Math.random() * 500000;
			Student s = new Student("" + a, "" + b, c);
			assertTrue("student toString does not contain entire student name", s.toString().contains("" + a));
			assertTrue("student toString does not contain entire student name", s.toString().contains("" + b));
			assertTrue("student toString does not contain student ID", s.toString().contains("" + c));
		}
	}

	@Test
	public void testStudentEquals() {
		Student s = new Student("Paul", "Smith", 000001);
		Student s1 = new Student("Paul", "Smith", 000001);
		Student s2 = new Student("Paul", "Smith", 000000);
		Student s3 = new Student("Pablo", "Smith", 000001);
		Student s4 = new Student("Paul", "Smitty", 000001);
		assertTrue("Equals: True doesn't work", s.equals(s1));
		assertFalse("Equals: False #1 doesn't work", s.equals(s2));
		assertFalse("Equals: False #2 doesn't work", s.equals(s3));
		assertFalse("Equals: False #3 doesn't work", s.equals(s4));
	}



	// TESTING COURSE CLASS HERE . . . FEEL FREE TO WRITE YOUR OWN, BUT DON'T CHANGE THIS ONE
	// once again, we are watching you
	
	ArrayList<Course> allTestCourses = new ArrayList<Course>();

	@Test
	public void testCourseInit() {
		Course c = new Course("CSE131", 1, 2);
		allTestCourses.add(c);
		assertEquals("CSE131", c.getName());
		assertEquals(2, c.getRemainingSeats());
		for (int i = 0; i < 20; ++i) {
			double a =  (Math.random() * 5000);
			int s = (int)(Math.random() * 5000);
			Course c2 = new Course("" + a, s, s);
			allTestCourses.add(c2);
			assertEquals("course getName() not working, or name not being set properly", "" + a, c2.getName());
			assertEquals("course getRemainingSeats() not working, or seats not being set properly", s, c2.getRemainingSeats());
		}
	}

	@Test
	public void testAddStudent() {
		for (int i = 0; i < 100; i++) {
			double a =  (Math.random() * 5000);
			int s = (int)(Math.random() * 50);
			Course c = new Course("" + a, s, s);
			allTestCourses.add(c);

			for (int j = 0; j < s; j++) {
				String aa =  "" + (Math.random() * 5000);
				String b =  "" + (Math.random() * 5000);
				int cc = (int)Math.random() * 500000;
				Student s2 = new Student(aa, b, cc);
				boolean added = c.addStudent(s2);
				assertTrue("addStudent not working properly", added);

				assertEquals("seats not updated after adding a student", s - j - 1, c.getRemainingSeats());
			}

			//Try to add students, even though the class is full.
			for (int j = 0; j < s; j++) {
				String aa =  "" + (Math.random() * 5000);
				String b =  "" + (Math.random() * 5000);
				int cc = (int)Math.random() * 500000;
				Student s2 = new Student(aa, b, cc);
				boolean added = c.addStudent(s2);

				assertTrue("addStudent not working properly: student added even though class was full", !added);
			}
		}
	}

	@Test
	public void testAverageGPA() {
		for (int j = 0; j < 100; j++) {
			double a =  (Math.random() * 5000);
			int s = (int)(Math.random() * 50 + 50);
			Course c = new Course("" + a, s, s);
			allTestCourses.add(c);

			double gpaSum = 0;
			for(int i = 0; i < s; i++) {
				String aa =  "" + (Math.random() * 5000);
				String b =  "" + (Math.random() * 5000);
				int cc = (int)(Math.random() * 500000);
				Student s2 = new Student(aa, b, cc);
				double g = Math.round(Math.random() * 4000) / 1000.0;
				gpaSum += g;
				s2.submitGrade(g, 1);
				c.addStudent(s2);
				assertEquals("course averageGPA() not working properly", gpaSum / (i + 1), c.averageGPA(), 0.01);
			}
		}
	}

	@Test
	public void testCourseToString() {
		for (int i = 0; i < 100; i++) {
			double a =  (Math.random() * 5000);
			int c = (int)Math.random() * 500000;
			Course cc = new Course("" + a, c, c);
			allTestCourses.add(cc);
			assertTrue("course toString does not contain course name", cc.toString().contains("" + a));
			assertTrue("course toString does not contain credits", cc.toString().contains("" + c));
		}
	}
	
	@Test
	public void testGetAllCourses() {
		//ArrayList<Course> allTestCourses = new ArrayList<Course>();
		
		for (int i = 0; i < 100; i++) {
			int c = (int)Math.random() * 500000;
			Course c5 = new Course("" + i, c, c);
			allTestCourses.add(c5);
		}
		/*
		for (int i = 0; i < allTestCourses.size(); i++){
			System.out.println("\n" + allTestCourses.get(i));
		}
		System.out.println("\n" + Course.getAllCourses()); */
		assertTrue("All Courses not present in the Lists", Course.getAllCourses().containsAll(allTestCourses));		
	}

	@Test
	public void testCourseEquals() {
		Student s = new Student("Paul", "Smith", 000001);
		Student s1 = new Student("Paula", "Smith", 000002);
		Student s2 = new Student("Paul", "Smith", 000003);
		Course c = new Course("CS100", 1, 2);
		Course c1 = new Course("CS100", 1, 2);
		Course c2 = new Course("CS101", 1, 2);
		Course c3 = new Course("CS100", 1, 2);
		
		c.addStudent(s);
		c.addStudent(s1);
		c1.addStudent(s);
		c1.addStudent(s1);
		c2.addStudent(s);
		c2.addStudent(s1);
		c3.addStudent(s);
		c3.addStudent(s2);
		
		assertTrue("Course Equals: True doesn't work", c.equals(c1));
		assertFalse("Course Equals: False #1 doesn't work", c.equals(c2));
		assertFalse("Course Equals: False #2 doesn't work", c.equals(c3));	
	}

}