
public class Attack extends Robot{
	
	private String weapons;
	private int damageScale, health;
	private boolean isAttacking;

	public Attack(String name) {
		super(name);
		this.weapons = "";
		this.isAttacking = false;
		this.damageScale = 0;
	}
	
	public Attack(String name, int xCoord, int yCoord) {
		super(name, xCoord, yCoord);
		this.weapons = "";
		this.isAttacking = false;
		this.damageScale = 0;
		this.health = 100;
	}
	
	public Attack(String name, int xCoord, int yCoord, int speed) {
		super(name, xCoord, yCoord, speed);
		this.weapons = "";
		this.isAttacking = false;
		this.damageScale = 0;
		this.health = 100;
	}
	
	public Attack(String name, int xCoord, int yCoord, int speed, int dir) {
		super(name, xCoord, yCoord, speed, dir);
		this.weapons = "";
		this.isAttacking = false;
		this.damageScale = 0;
		this.health = 100;
	}
	
	public Attack(String name, int xCoord, int yCoord, int speed, int dir, String weapon, int damage) {
		super(name, xCoord, yCoord, speed, dir);
		this.weapons = weapon;
		this.isAttacking = false;
		this.damageScale = damage;
		this.health = 100;
	}
	
	public boolean attackRobot(Attack r){
		boolean attacked = this.useWeapon(r);
		this.setAttacking(true);
		return attacked;
	}
	private boolean useWeapon(Attack r){
		//The robot needs to be next to another robot to inflict any damage
		if((this.getX() == r.getX()) || (this.getX() == (r.getX() - 1)) || (this.getX() == (r.getX() + 1))){
			if((this.getY() == r.getY()) || (this.getY() == (r.getY() - 1)) || (this.getY() == (r.getY() + 1))){
				r.setHealth(r.getHealth() - this.getDamageScale());
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public void moveCloser(Attack r){
		int xDifference = this.getX() - r.getX();
		int yDifference = this.getY() - r.getY();
		int xAbs = Math.abs(xDifference);
		int yAbs = Math.abs(yDifference);
		if ((xAbs < yAbs)  && (xAbs != 0)){
			if (xDifference < 0){
				this.setOrientation(1);
				if(this.getSpeed() > xAbs){
					this.setSpeed(xAbs);
				}
			}
			else{
				this.setOrientation(3);
				if(this.getSpeed() > xAbs){
					this.setSpeed(xAbs);
				}
			}
		}
		else if (yAbs != 0){
			if (yDifference < 0){
				this.setOrientation(0);
				if(this.getSpeed() > yAbs){
					this.setSpeed(yAbs);
				}
			}
			else{
				this.setOrientation(2);
				if(this.getSpeed() > yAbs){
					this.setSpeed(yAbs);
				}
			}
		}
		this.move();		
	}

	/**
	 * @return the damageScale
	 */
	public int getDamageScale() {
		return damageScale;
	}

	/**
	 * @param damageScale the damageScale to set
	 */
	public void setDamageScale(int damageScale) {
		this.damageScale = damageScale;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
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
	
	public String toString(){
		return (super.toString() + "\nWith a Health of " + this.getHealth());		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Attack arg = new Attack("Aggressor", 0, 0, 1, 0, "Battle Axe", 5);
		Attack def = new Attack("Runner", 0, 5, 3, 1, "knife", 6);
		
		System.out.println(arg + "\n");
		System.out.println(def + "\n");
		
		AggressiveBehavior arg9 = new AggressiveBehavior(5);
		DefensiveBehavior def5 = new DefensiveBehavior(5);
		
		arg.setBehavior(arg9);
		def.setBehavior(def5);
		
		def5.intialize(def);
		arg9.intialize(arg);
		
		System.out.println(arg + "\n");
		System.out.println(def + "\n");
		
		int moves = 1;
		boolean winner = false;
		do{
			def5.doNextMove(arg, def);
			arg9.doNextMove(arg, def);
			System.out.println("After move " + moves);
			System.out.println(arg + "\n");
			System.out.println(def + "\n");
			
			if(arg.getHealth() <= 0 || def.getHealth() <= 0){
				winner = true;
			}
			
			moves++;
			
		}while(winner == false);
		
		if (def.getHealth() <= 0){
			System.out.println("The winner is " + arg.getName() + "!");
		}
		else{
			System.out.println("The winner is " + def.getName() + "!");
		}
	}

}
