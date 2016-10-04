import java.text.DecimalFormat;

public class Course {
	
	private String name;
	private int credits, numberOfSeats, remainingSeats;
	private Student[] rosterOfStudents;

	public Course(String name, int credit, int seats) {
		this.name = name;
		this.credits = credit;
		this.numberOfSeats = seats;
		this.remainingSeats = seats;
		this.rosterOfStudents = new Student[seats];
		// load the course with dummy students to avoid null exception errors
		for(int i = 0; i < this.rosterOfStudents.length; i++){
			this.rosterOfStudents[i] = new Student("a", "b", -1);
		}
	}
	
	public boolean addStudent(Student s){
		// are there still seats?
		if(this.remainingSeats <= 0){
			return false;
		}
		
		// is this student already in the class?
		for(int i = 0; i < this.rosterOfStudents.length; i++){
			if (s.getFullName() == this.rosterOfStudents[i].getFullName()){
				return false;
			}
		}
		
		// Add the student if the method gets to this point in the code
		int i = 0;
		while (this.rosterOfStudents[i].getStudentID() != -1){
			i++;
		}
		this.rosterOfStudents[i] = s;
		this.remainingSeats--;
		return true;
	}
	
	public String generateRoster(){
		String roster = "";
		for(int i = 0; i < (this.numberOfSeats - this.remainingSeats); i++){
			roster = roster + this.rosterOfStudents[i].getName() + "\n";			
		}
		return roster;
	}
	
	public double averageGPA(){
		DecimalFormat df = new DecimalFormat("#.000");
		double avg = 0;
		int numberOfStudents = this.numberOfSeats - this.remainingSeats;
		for(int i = 0; i < numberOfStudents; i++){
			avg += this.rosterOfStudents[i].getGPA();			
		}
		return (Double.valueOf(df.format(avg / numberOfStudents)));
	}

	
	/**
	 * @return the name
	 */
 	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * @param credits the credits to set
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 * @return the numberOfSeats
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	/**
	 * @param numberOfSeats the numberOfSeats to set
	 */
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	/**
	 * @return the remainingSeats
	 */
	public int getRemainingSeats() {
		return remainingSeats;
	}
	

	/**
	 * @param remainingSeats the remainingSeats to set
	 */
	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}
	

	/**
	 * @return the rosterOfStudents
	 */
	public Student[] getRosterOfStudents() {
		return rosterOfStudents;
	}

	/**
	 * @param rosterOfStudents the rosterOfStudents to set
	 */
	public void setRosterOfStudents(Student[] rosterOfStudents) {
		this.rosterOfStudents = rosterOfStudents;
	}
	
	public String toString(){
		return ("Course: " + this.name + "\nCredits: " + this.credits);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student p = new Student("Paul", "Keuss", 123456);
		Student o = new Student("Ozzie", "Smith", 122334);
		Student b = new Student("Bob", "Gibson", 133334);
		Course c = new Course("ZZZ", 3, 2);
		boolean added = c.addStudent(p);
		System.out.println(c.generateRoster());
		System.out.println(c.rosterOfStudents[1].getFullName());
		added = c.addStudent(o);
		System.out.println(c.generateRoster());
		added = c.addStudent(p);
		boolean added1 = c.addStudent(b);
		System.out.println(c.remainingSeats);
		System.out.println(c.generateRoster());
		System.out.println(c);
	}
}
