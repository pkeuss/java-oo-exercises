
public class Attack extends Robot{
	
	private String weapons;
	private boolean isAttacking;

	public Attack(String name) {
		super(name);
		this.weapons = "";
		this.isAttacking = false;
	}
	
	public Attack(String name, int xCoord, int yCoord) {
		super(name, xCoord, yCoord);
		this.weapons = "";
		this.isAttacking = false;
	}
	
	public Attack(String name, int xCoord, int yCoord, int speed) {
		super(name, xCoord, yCoord, speed);
		this.weapons = "";
		this.isAttacking = false;
	}
	
	public Attack(String name, int xCoord, int yCoord, int speed, int dir) {
		super(name, xCoord, yCoord, speed, dir);
		this.weapons = "";
		this.isAttacking = false;
	}
	
	public Attack(String name, int xCoord, int yCoord, int speed, int dir, String weapon) {
		super(name, xCoord, yCoord, speed, dir);
		this.weapons = weapon;
		this.isAttacking = false;
	}

	/**
	 * @return the weapons
	 */
	public String getWeapons() {
		return weapons;
	}

	/**
	 * @param weapons the weapons to set
	 */
	public void setWeapons(String weapons) {
		this.weapons = weapons;
	}

	/**
	 * @return the isAttacking
	 */
	public boolean isAttacking() {
		return isAttacking;
	}

	/**
	 * @param isAttacking the isAttacking to set
	 */
	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
