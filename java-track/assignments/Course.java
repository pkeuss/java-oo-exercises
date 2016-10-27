//<<<<<<< HEAD
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Course {
	
	private String name;
	private int credits, numberOfSeats, remainingSeats;
	private Student[] rosterOfStudents;
	private static ArrayList<Course> allCourses = new ArrayList<Course>();

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
		Course.allCourses.add(this);
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

	/**
	 * @return the allCourses
	 */
	public static ArrayList<Course> getAllCourses() {
		return allCourses;
	}
	
	@Override
	public boolean equals(Object o){
		//points to the same thing?
		if(this == o){
			return true;
		}
		
		//null check
		if(o == null){
			return false;
		}
		
		//check for the same class
		if(getClass() != o.getClass()){
			return false;
		}
		
		Course c = (Course) o;
		
		boolean equal = true;
		Student[] compare = c.getRosterOfStudents();
		
		if(this.getName().equals(c.getName())){
			if(compare.length == this.rosterOfStudents.length){
				for(int i = 0; i < compare.length; i++){
					if(!compare[i].equals(this.rosterOfStudents[i])){
						equal = false;
					}
				}
			}
			else{
				equal = false;
			}
		}
		else{
			equal = false;
		}
		return equal;
	}

	
}
/*
=======

public class Course {

	private String name;
	private int credits;
	private int remainingSeats;
	private Student[] roster;

	public Course(String name, int credits, int numberOfSeats) {
		this.roster = new Student[numberOfSeats];
		this.name = name;
		this.credits = credits;
		this.remainingSeats = numberOfSeats;
	}

	public String getName() {
		return name;
	}
	public int getCredits() {
		return credits;
	}
	public int getRemainingSeats() {
		return remainingSeats;
	}
	public Student[] getRoster() {
		return roster;
	}

	public Boolean addStudent(Student newStudent) {

		if (this.remainingSeats == 0) {
			return false;
		}

		// check to make sure student hasn't already enrolled
		for (int i = 0; i < roster.length; i++) {
			if (roster[i] != null && roster[i].getName() == newStudent.getName()) {
				return false;
			}
		}

		roster[roster.length - this.remainingSeats] = newStudent;
		remainingSeats--;

		return true;
	}

	public double averageGPA() {

		double sum = 0.0;
		int numberOfStudents = 0;
		for (int i = 0; i < roster.length; i++) {
			if (roster[i] != null) {
				sum += roster[i].getGPA();
				numberOfStudents++;
			}
		}

		return sum / numberOfStudents;
	}

	public String generateRoster() {

		String rosterString = "";
		for (int i = 0; i < roster.length; i++) {
			if (roster[i] != null) {
				rosterString = rosterString + roster[i].getName() + "\n";
			}
		}

		return rosterString;
	}

	public String toString() {
		return this.name + "(" + this.credits + ")";
	}

}
>>>>>>> refs/remotes/launchcode/master
*/
