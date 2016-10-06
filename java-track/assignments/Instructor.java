import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;

public class Instructor {
	
	//Instructors have:
	private boolean tenure, professor; //if they are not a professor then they are considered a TA
	private String firstName, lastName;
	private double salary;
	private int yearsOfService;
	private Course[] currentCourses;
	
	/**
	 * Constructor
	 * @param first
	 * @param last
	 */
	public Instructor(String first, String last){
		this.firstName = first;
		this.lastName = last;
		this.tenure = false;
		this.professor = false;
		this.salary = 20000.00; //TA makes a minimum of $20,000
		this.yearsOfService = 0;
		this.currentCourses = new Course[7]; //Should not teach more than 7 courses a semester
		
		//Setting up "filler" information to be updated every semester
		for(int i = 0; i < this.currentCourses.length; i++){
			this.currentCourses[i] = new Course("a", 0, 200);
		}
		
				
	}
	

	/**
	 * @return the tenure
	 */
	public boolean isTenure() {
		return tenure;
	}


	/**
	 * set tenure to true if it is false or
	 * set tenure to false if it is true
	 */
	public void setTenure() {
		if (this.tenure == false){
			this.tenure = true;
		}
		else{
			this.tenure = false;
		}
	}

	/**
	 * 
	 * @return "FirstName LastName" (John Doe)
	 */
	public String getFullName() {
		return (this.firstName + " " + this.lastName);
	}
	
	
	/**
	 * 
	 * @return "LastName, FirstName" (Doe, John)
	 */
	public String getFileName() {
		return (this.lastName + ", " + this.firstName);
	}
	
	
	/**
	 * @return the professor
	 */
	public boolean isProfessor() {
		return professor;
	}


	/**
	 * set professor to true if it is false or
	 * set professor to false if it is true
	 */
	public void setProfessor() {
		if (this.professor == false){
			this.professor = true;
		}
		else{
			this.professor = false;
		}
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the salary
	 */
	public double getSalary() {
		DecimalFormat df = new DecimalFormat("#######.00");
		return (Double.valueOf(df.format(this.salary)));
	}


	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		DecimalFormat df = new DecimalFormat("#######.00");
		this.salary = (Double.valueOf(df.format(salary)));
	}


	/**
	 * @return the yearsOfService
	 */
	public int getYearsOfService() {
		return yearsOfService;
	}


	/**
	 * @param yearsOfService the yearsOfService to set
	 */
	public void setYearsOfService(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}
	
	
	/**
	 * add 1 year to the years of service variable
	 */
	public void addYear() {
		this.yearsOfService++;
	}

	
	public boolean addCourse(Course c){
		int index = 0;
		// has the instructor reached the maximum amount of courses allowed to be taught
		// by one instructor in a semester?
		// Also find out which spot in the array to add this course if there are openings
		while ((index < this.currentCourses.length) && (this.currentCourses[index].getName() != "a")){
			index++;
		}
		
		if (index >= this.currentCourses.length){
			return false;
		}
		
		// Add the course if the instructor has an opening 
		this.currentCourses[index] = c;
		return true;
	}
	
	
	public String generateCourseList(){
		String courseList = "";
		for(int i = 0;((i < this.currentCourses.length) && (this.currentCourses[i].getName() != "a")); ++i){
			courseList = courseList + this.currentCourses[i].getName() + "\n";
		}
		return courseList;
	}
	
	
	public void resetCourseList(){
		for(int i = 0; i < this.currentCourses.length; i++){
			this.currentCourses[i] = new Course("a", 0, 200);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Instructor i = new Instructor("p", "k");
		System.out.println(i.generateCourseList());
		Course c0 = new Course("c0", 1, 2);
		i.addCourse(c0);
		Course c1 = new Course("c1", 1, 2);
		i.addCourse(c1);
		Course c2 = new Course("c2", 1, 2);
		i.addCourse(c2);
		System.out.println(i.generateCourseList());
		Course c3 = new Course("c3", 1, 2);
		i.addCourse(c3);
		Course c4 = new Course("c4", 1, 2);
		i.addCourse(c4);
		Course c5 = new Course("c5", 1, 2);
		i.addCourse(c5);
		Course c6 = new Course("c6", 1, 2);
		i.addCourse(c6);
		System.out.println(i.generateCourseList());
		i.resetCourseList();
		System.out.println(i.generateCourseList());
	}

}
