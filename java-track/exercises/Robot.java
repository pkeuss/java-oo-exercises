
public class Robot {
	
	private String Name;
	/*
	 * for Orientation: 
	 *  0 = North
	 *  1 = East
	 *  2 = South
	 *  3 = West
	 */
	private int X, Y, Speed, Orientation;
	
	public Robot(String name) {
		this.Name = name;
		this.Orientation = 0;
		this.X = 0;
		this.Y = 0;
		this.Speed = 0;
	}
	
	public Robot(String name, int xCoord, int yCoord) {
		this.Name = name;
		this.Orientation = 0;
		this.X = xCoord;
		this.Y = yCoord;
		this.Speed = 0;
	}
	
	public Robot(String name, int xCoord, int yCoord, int speed) {
		this.Name = name;
		this.Orientation = 0;
		this.X = xCoord;
		this.Y = yCoord;
		this.Speed = speed;
	}
	
	public Robot(String name, int xCoord, int yCoord, int speed, int dir) {
		this.Name = name;
		this.X = xCoord;
		this.Y = yCoord;
		this.Speed = speed;
		if((dir >= 0) && (dir <= 3)){
			this.Orientation = dir;
		}
		else{
			this.Orientation = 0;
		}
			
	}
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getSpeed() {
		return Speed;
	}

	public void setSpeed(int speed) {
		Speed = speed;
	}

	public int getOrientation() {
		return Orientation;
	}
	
	public String getOrientation(boolean word) {
		if (word == true){
			switch (this.Orientation) {
			
			case 0:
				return "North";
				
			case 1:
				return "East";
				
			case 2:
				return "South";
				
			case 3:
				return "West";
				
			default:
				return "Unknown";				
			}
		}
		return ("Use other getOrientation function for number value");
	}

	public void setOrientation(int orientation) {
		Orientation = orientation;
	}
	
	public void right() {
		switch (this.Orientation) {
		
		case 0:
			this.Orientation = 1;
			break;
			
		case 1:
			this.Orientation = 2;
			break;
			
		case 2:
			this.Orientation = 3;
			break;
			
		case 3:
			this.Orientation = 0;
			break;
			
		default:
			this.Orientation = 0;
			break;
		}
	}
	
	public void left() {
		switch (this.Orientation) {
		
		case 0:
			this.Orientation = 3;
			break;
			
		case 1:
			this.Orientation = 0;
			break;
			
		case 2:
			this.Orientation = 1;
			break;
			
		case 3:
			this.Orientation = 2;
			break;
			
		default:
			this.Orientation = 0;
			break;
		}
	}
	
	public void move() {
		int x = this.getX();
		int y = this.getY();
		int speed = this.getSpeed();
		int direction = this.getOrientation();
		
		switch (direction) {
		
		case 0:
			this.setY(y + speed);
			break;
			
		case 1:
			this.setX(x + speed);
			break;
			
		case 2:
			this.setY(y - speed);
			break;
			
		case 3:
			this.setX(x - speed);
			break;
			
		default:
			break;
		}
	}
	
	public String howFar(Robot r) {
		int x = this.X - r.getX();
		int y = this.Y - r.getY();
		double c = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return (this.Name + " is " + x + " away on the x-plane and is " + y + " away on the y-plane, from " + r.getName() +
				"\nOr " + c + " units away as the crow flies");
	}
	
	public String toString() {
		return("Name: " + this.Name + "\nPosition: (" + this.X + "," + this.Y + ")\nSpeed: " +
					this.Speed + "\nOrientation: " + this.getOrientation(true));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot r2 = new Robot("R2D2");
		Robot r = new Robot("C3PO", 20, 20, 2, 2);
		r2.setSpeed(5);
		r2.move();
		r2.left();
		r2.move();
		System.out.println(r2.toString());
		System.out.println("\n" + r2.howFar(r) + "\n");
		System.out.println(r.toString());
	}

}
