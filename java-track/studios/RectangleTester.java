import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RectangleTester {

	@Test
	public void testRectangle() {
		Rectangle r = new Rectangle();
		assertTrue("Problem with empty constructor and the length", r.getLength() == 0);
		assertTrue("Problem with empty constructor and the width", r.getWidth() == 0);
		
		Rectangle r1 = new Rectangle(3, 4);
		assertTrue("Problem with empty constructor and the length", r1.getLength() == 3);
		assertTrue("Problem with empty constructor and the width", r1.getWidth() == 4);
	}
	
	
	@Test
	public void testArea() {
		Rectangle r = new Rectangle(12, 12);
		assertTrue("Problem with computing the Area of r", r.Area() == 144);
		
		Rectangle r1 = new Rectangle(3, 4);
		assertTrue("Problem with computing the Area of r1", r1.Area() == 12);
	}
	
	@Test
	public void testPerimeter() {
		Rectangle r = new Rectangle(12, 12);
		assertTrue("Problem with computing the Perimeter of r", r.Perimeter() == 48);
		
		Rectangle r1 = new Rectangle(3, 4);
		assertTrue("Problem with computing the Perimeter of r1", r1.Perimeter() == 14);
	}
	
	
	@Test
	public void testSquare() {
		Rectangle r = new Rectangle(12, 12);
		assertTrue("Problem with Square() Method of r", r.Square() == true);
		
		Rectangle r1 = new Rectangle(3, 4);
		assertTrue("Problem with Square() Method of r1", r1.Square() == false);
	}
	
	@Test
	public void testSmaller() {
		Rectangle r = new Rectangle(12, 12);
		Rectangle r1 = new Rectangle(3, 4);
		assertTrue("Problem with SmallerThan() Method of r", r.smallerThan(r1) == false);		
		assertTrue("Problem with SmallerThan() Method of r1", r1.smallerThan(r) == true);
	}
	
	
	@Test
	public void testToString() {
		Rectangle r = new Rectangle(12, 12);
		Rectangle r1 = new Rectangle(3, 4);
		assertTrue("Problem with toString() Method of r", r.toString().contains("12"));		
		assertTrue("Problem with toString() Method of r1", r1.toString().contains("3") && r1.toString().contains("4"));
	}
}
