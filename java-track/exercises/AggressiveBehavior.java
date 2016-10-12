
public class AggressiveBehavior implements RobotBehavior{
	
	private int aggressiveScale; //1 - 10

	public AggressiveBehavior(int scale) {
		// TODO Auto-generated constructor stub
		this.aggressiveScale = scale;
	}


	@Override
	public void doNextMove(Attack attacker, Attack victim) {
		// TODO Auto-generated method stub		
		boolean hit = attacker.attackRobot(victim);
		if (hit == false){
			attacker.moveCloser(victim);
			
			//max out at a speed of 15
			if(attacker.getSpeed() < 15){
				attacker.setSpeed(attacker.getSpeed()+1);
			}
			//try to hit again, before the victim reacts 
			hit = attacker.attackRobot(victim);
		}
		else{
			this.intialize(attacker);
		}
	}


	@Override
	public void intialize(Attack r) {
		// TODO Auto-generated method stub
		r.setSpeed(this.aggressiveScale);
	}

	
	

}
