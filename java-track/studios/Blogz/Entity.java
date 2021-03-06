package Blogz;

import java.util.ArrayList;

public abstract class Entity {
	
	private final int uid;
	private static ArrayList<Integer> uidList = new ArrayList<Integer>(); 
	

	public Entity() {
		this.uid = this.createUniqueID();
		//uidList.add(this.uid);
	}

	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}
	
	/**
	 * 
	 * @return
	 */
	private Integer createUniqueID(){
		int i = uidList.size();
		i++;
		uidList.add(i);
		return i;
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
		
		Entity e = (Entity) o;
		
		//field comparison
		return(this.getUid() == e.getUid());
	}
	
	public static void main(String[] args){
		User e = new User("eek4", "e");
		User f = new User("eeek5", "e");
		User g = new User("eek6", "e");
		
		System.out.println(e.getUid());
		System.out.println(f.getUid());
		System.out.println(g.getUid());
	}
	

}
