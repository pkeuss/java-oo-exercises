

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTester {
	

	@Test
	public void testRobot() {
		Robot r = new Robot("r");
		assertTrue("Orientation: Problem getting the number value of robot after construction", r.getOrientation() == 0);
		assertTrue("Orientation: Problem getting the word value of robot after construction", r.getOrientation(true) == "North");
		assertTrue("Speed: Problem getting the number value of robot after construction", r.getSpeed() == 0);
		assertTrue("X-Value: Problem getting the number value of robot after construction", r.getX() == 0);
		assertTrue("Y-Value: Problem getting the number value of robot after construction", r.getY() == 0);
		
		Robot r1 = new Robot("r1", 1, 1);
		assertTrue("Orientation: Problem getting the number value of robot after construction", r1.getOrientation() == 0);
		assertTrue("Orientation: Problem getting the word value of robot after construction", r1.getOrientation(true) == "North");
		assertTrue("Speed: Problem getting the number value of robot after construction", r1.getSpeed() == 0);
		assertTrue("X-Value: Problem getting the number value of robot after construction", r1.getX() == 1);
		assertTrue("Y-Value: Problem getting the number value of robot after construction", r1.getY() == 1);
		
		Robot r2 = new Robot("r2", 2, 2, -2);
		assertTrue("Orientation: Problem getting the number value of robot after construction", r2.getOrientation() == 0);
		assertTrue("Orientation: Problem getting the word value of robot after construction", r2.getOrientation(true) == "North");
		assertTrue("Speed: Problem getting the number value of robot after construction", r2.getSpeed() == -2);
		assertTrue("X-Value: Problem getting the number value of robot after construction", r2.getX() == 2);
		assertTrue("Y-Value: Problem getting the number value of robot after construction", r2.getY() == 2);
		
		Robot r3 = new Robot("r3", 5, -5, 5, 3);
		assertTrue("Orientation: Problem getting the number value of robot after construction", r3.getOrientation() == 3);
		assertTrue("Orientation: Problem getting the word value of robot after construction", r3.getOrientation(true) == "West");
		assertTrue("Speed: Problem getting the number value of robot after construction", r3.getSpeed() == 5);
		assertTrue("X-Value: Problem getting the number value of robot after construction", r3.getX() == 5);
		assertTrue("Y-Value: Problem getting the number value of robot after construction", r3.getY() == -5);
		
		Robot r4 = new Robot("r3", 5, -5, 5, 5);
		assertTrue("Orientation: Problem getting the number value of robot after construction", r4.getOrientation() == 0);
		assertTrue("Orientation: Problem getting the word value of robot after construction", r4.getOrientation(true) == "North");
		assertTrue("Speed: Problem getting the number value of robot after construction", r4.getSpeed() == 5);
		assertTrue("X-Value: Problem getting the number value of robot after construction", r4.getX() == 5);
		assertTrue("Y-Value: Problem getting the number value of robot after construction", r4.getY() == -5);
	}
	
	
	@Test
	public void testRight() {
		Robot r = new Robot("r");
		assertTrue("Orientation: Problem getting the number value of robot after construction", r.getOrientation() == 0);
		assertTrue("Orientation: Problem getting the word value of robot after construction", r.getOrientation(true) == "North");
		r.right();
		assertTrue("Orientation: Problem using right() method going from 0 - 1",r.getOrientation() == 1);
		assertTrue("Orientation: Problem using right() method going from North - East",r.getOrientation(true) == "East");
		r.right();
		assertTrue("Orientation: Problem using right() method going from 1 - 2",r.getOrientation() == 2);
		assertTrue("Orientation: Problem using right() method going from East - South",r.getOrientation(true) == "South");
		r.right();
		assertTrue("Orientation: Problem using right() method going from 2 - 3",r.getOrientation() == 3);
		assertTrue("Orientation: Problem using right() method going from South - West",r.getOrientation(true) == "West");
		r.right();
		assertTrue("Orientation: Problem using right() method going from 3 - 0",r.getOrientation() == 0);
		assertTrue("Orientation: Problem using right() method going from West - North",r.getOrientation(true) == "North");
	}
	
	
	
	@Test
	public void testLeft() {
		Robot r = new Robot("r");
		assertTrue("Orientation: Problem getting the number value of robot after construction", r.getOrientation() == 0);
		assertTrue("Orientation: Problem getting the word value of robot after construction", r.getOrientation(true) == "North");
		r.left();
		assertTrue("Orientation: Problem using left() method going from 0 - 3",r.getOrientation() == 3);
		assertTrue("Orientation: Problem using left() method going from North - West",r.getOrientation(true) == "West");
		r.left();
		assertTrue("Orientation: Problem using left() method going from 3 - 2",r.getOrientation() == 2);
		assertTrue("Orientation: Problem using left() method going from West - South",r.getOrientation(true) == "South");
		r.left();
		assertTrue("Orientation: Problem using left() method going from 2 - 1",r.getOrientation() == 1);
		assertTrue("Orientation: Problem using left() method going from South - East",r.getOrientation(true) == "East");
		r.left();
		assertTrue("Orientation: Problem using left() method going from 1 - 0",r.getOrientation() == 0);
		assertTrue("Orientation: Problem using left() method going from East - North",r.getOrientation(true) == "North");
	}
	
	
	
	@Test
	public void testMove() {
		Robot r = new Robot("r");
		r.setSpeed(1);
		assertTrue("Speed: Problem setting the Speed of the robot", r.getSpeed() == 1);
		r.move();
		assertTrue("X-Value: Problem with the x-value after the move() method invoked in the north direction", r.getX() == 0);
		assertTrue("Y-Value: Problem with the y-value after the move() method invoked in the north direction", r.getY() == 1);
		r.right();
		r.move();
		assertTrue("X-Value: Problem with the x-value after the move() method invoked in the east direction", r.getX() == 1);
		assertTrue("Y-Value: Problem with the y-value after the move() method invoked in the east direction", r.getY() == 1);
		r.right();
		r.move();
		assertTrue("X-Value: Problem with the x-value after the move() method invoked in the south direction", r.getX() == 1);
		assertTrue("Y-Value: Problem with the y-value after the move() method invoked in the south direction", r.getY() == 0);
		r.right();
		r.move();
		assertTrue("X-Value: Problem with the x-value after the move() method invoked in the west direction", r.getX() == 0);
		assertTrue("Y-Value: Problem with the y-value after the move() method invoked in the west direction", r.getY() == 0);
		
	}
	

	@Test
	public void testHowFar() {
		Robot r = new Robot("r");
		Robot r1 = new Robot("r1", 10, -5);
		assertTrue("Problem with the howFar() method" + r.howFar(r1), r.howFar(r1).contains("-10") && r.howFar(r1).contains("5"));
		
	}

}
