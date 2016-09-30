
public class Rectangle {

	// a rectangle has-a:
	private double length, width;
	
	public Rectangle() {
	this.width = 0;  // a new rectangle has a width
	this.length = 0; //and a length
	}

	/**
	* 
	* @param l - initial length
	* @param w - initial width
	*/
	public Rectangle(double l, double w) {
	this.length = l;
	this.width = w;
	}
	/**
	* 
	* @returns the area of the rectangle (length x width)
	*/
	public double Area(){
	return (this.length * this.width);
	}
	/**
	* 
	* @returns the perimeter (2 x length + 2 x width)
	*/
	public double Perimeter(){
	return ((2*this.length) + (2*width));
	}
	/**
	* 
	* @returns true if the rectangle is a square
	*/
	public boolean Square(){
	if(this.length == this.width) return true;
	return false;
	}
	/**
	* 
	* @param r - rectangle to compare area against
	* @return - if this rectangle is smaller = true; bigger = false
	*/
	public boolean smallerThan(Rectangle r){
	if(r.Area() > this.Area()) return true;
	return false;
	}
	/**
	* return a string indicating the length and width of the rectangle
	*/
	public String toString() {
	return "Rectangle with " + this.length + " length and " + this.width + " width";
	}
	
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	boolean small = false;
	Rectangle r1 = new Rectangle();
	r1.length = 10;
	r1.width = 5;
	System.out.println(r1);
	System.out.println("The Area is " + r1.Area() + " and the Perimeter is " + r1.Perimeter() + "\n");
	System.out.println("Is r1 a square?: " + r1.Square());
	Rectangle r2 = new Rectangle(4, 4);
	System.out.println("Is r2 a Square?: " + r2.Square());
	small = r2.smallerThan(r1);
	System.out.println("Is r2 smaller than r1?: " + small);
	small = r1.smallerThan(r2);
	System.out.println("Is r1 smaller than r2?: " + small);
	}

}
