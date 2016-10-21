package Blogz;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class User extends Entity{
	
	private String username, hashedPassword;
	private static ArrayList<User> allUsers = new ArrayList<User>();
	
	public User(String name, String password){
		super();
		/*
		 * Because i am forced to put the super() first, i already assign a unique
		 * id for an entity that ultimately doesn't get created if the user name is invalid
		 * How can i remedy this???
		 * 
		 * if i use a do while loop for setting the user name maybe that would work 
		 * 
		 * If i had a set password method then i could still use the variable to set
		 * the user name and password
		 * 
		 * or i can "deconstruct" the entity and allUser if possible
		 * 
		 * I can't even put the super() inside the try block
		 */
		try{
			if (User.isValidUsername(name) == true){
				this.username = name;
			}
			this.hashedPassword = User.hashPassword(password);
			User.allUsers.add(this);
		}
		catch(IllegalArgumentException e){
			System.out.println("Invalid Username Format: Should be 4-12 characters long, starts with a\n" +
					"letter and can only contain letters, numbers, -, and _.");
			e.printStackTrace();
		}		
	}
	
	/**
	 * 
	 * @param password
	 * @return the hashed password
	 */
	private static String hashPassword(String password){
		return password;
	}
	
	/**
	 * Verify the password matches the hashed password
	 * @param password
	 * @return
	 */
	public boolean isValidPassword(String password){
		String hashCheck = User.hashPassword(password);
		
		if(hashCheck.equals(this.hashedPassword)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public void printUsersString(){
		for(int i = 0; i < allUsers.size(); i++){
			System.out.println("\n" + (i+1) + ".) " + allUsers.get(i));
		}
	}
		
	public String toString(){
		return ("Username:\t" + this.username);
	}

	/**
	 * @return the user name
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the user name to set
	 */
	public void setUsername(String username) {
		try{
			if (User.isValidUsername(username) == true){
				this.username = username;
			}
		}
		catch(IllegalArgumentException e){
			System.out.println("Invalid Username Format: Should be 4-12 characters long, starts with a\n" +
					"letter and can only contain letters, numbers, -, and _.");
			e.printStackTrace();
		}
	}

	/**
	 * @return the allUsers
	 */
	public static ArrayList<User> getAllUsers() {
		return allUsers;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isValidUsername(String name){
		if(Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", name)){
			return true;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public static void main(String[] args){
		User e = new User("eeek4", "e");
		User f = new User("eeek5", "e");
		User g = new User("eeek6", "e");
		User h = new User("7eke6", "e");
		
		System.out.println(e.getUid());
		System.out.println(f.getUid());
		System.out.println(g.getUid());
		System.out.println(h.getUid());
		System.out.println(h.getUsername());
	}
	

}
