
import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {
	
	private ArrayList<Robot> robots;
	private Scanner s;

	public static void main(String[] args) {

		int x = 0;
		RobotMenu rm = new RobotMenu();
		do {
			x = rm.startMenu();
			rm.processInput(x);
		}while (x != 6);

	}
	
	public RobotMenu(){
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}
	
	
	public int startMenu(){
		System.out.println("");
		System.out.println("Wlecome to the Robot Menu!");
		System.out.println("1. Create a robot");
		System.out.println("2. Display the list of availiable robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a robot");
		System.out.println("5. Compute the distance between two robots");
		System.out.println("6. Exit");
		System.out.println("Please select an option: ");
		
		int selection = s.nextInt();
		while(selection < 0 || selection > 6){
			System.out.println("Invalid slection, please try again: ");
			selection = s.nextInt();
		}
		return selection;
	}
	
	public void processInput(int selection){
		if (selection == 1){
			createRobot();		
		}
		
		else if (selection == 2){
			displayRobots();
		}
		
		else if (selection == 3){
			displayRobots();
			Robot r = selectRobot();
			r.move();
			System.out.println("Here is the status of the robot after it has moved:");
			System.out.println(r);
		}
		
		else if (selection == 4){
			displayRobots();
			Robot r = selectRobot();
			System.out.println("Would you like to rotate left or right?");
			boolean choiceIsOK = false;
		    do{
		    	String userinput = s.next();
		    	char choice = userinput.toLowerCase().charAt(0);
		    	switch(choice){
		    		case 'l':
		    			choiceIsOK = true;
		    			r.left();
		    			break;
		    		case 'r':
		    			choiceIsOK = true;
		    			r.right();
		    			break;
		    		default:
		    			System.out.println("Type right or left to indicate which direction yu would like to rotate: ");
		    			break;
		    	}
		    }while(!choiceIsOK);
			
		}
		
		else if (selection == 5){
			displayRobots();
			System.out.println("Please select the FIRST robot to compare the distance to: ");
			Robot r = selectRobot();
			System.out.println("Please select the SECOND robot to compare the distance to: ");
			Robot r1 = selectRobot();
			System.out.println(r.howFar(r1));
		}
	}
	
	
	private Robot selectRobot(){
		System.out.println("Please Select a Robot: ");
		int selection = s.nextInt();
		while(selection < 1 || selection > robots.size()){
			System.out.println("Invalid Selection, please try again: ");
			selection = s.nextInt();
		}
		return robots.get(selection - 1);
	}
	
	
	private void displayRobots(){
		for(int i = 0; i < robots.size(); i++){
			System.out.println("\n" + (i+1) + ".) " + robots.get(i));
		}
	}
	
	private void createRobot(){
		System.out.println("Please enter the name of the robot: ");
		String name = s.next();
		System.out.println("Please enter the X-coordinate you want the robot to start at: ");
		int x_coord = s.nextInt();
		System.out.println("Please enter the Y-coordinate you want the robot to start at: ");
		int y_coord = s.nextInt();
		System.out.println("Please enter the speed of the robot: ");
		int speed = s.nextInt();
		System.out.println("Please enter the orientation of the robot (0 = North, 1 = East, 2 = South, 3 = West): ");
		int dir = s.nextInt();
		while((dir < 0 || dir > 3)){
			System.out.println("Invalide value: Please enter a whole number 0 - 3: ");
			dir = s.nextInt();
		}
		robots.add(new Robot(name, x_coord, y_coord, speed, dir));	
	}
	/*
	 * 
	 */

}
