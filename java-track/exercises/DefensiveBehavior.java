
public class DefensiveBehavior implements RobotBehavior{
	
	private int defensiveScale; //1 - 10

	public DefensiveBehavior(int scale) {
		this.defensiveScale = scale;
	}

	@Override
	public void doNextMove(Attack attacker, Attack victim) {
		// In this case the victim is the defensive robot
		boolean hitAndRun = false;
		if(attacker.isAttacking() == true){
			hitAndRun = victim.attackRobot(attacker);
		}		
		victim.setAttacking(false);
		if(hitAndRun == true){
			double leftOrRight = Math.random();
			if( leftOrRight < 0.5){
				victim.left();
			}
			else{
				victim.right();
			}
			victim.setSpeed(this.defensiveScale);
			victim.move();
			this.intialize(victim);
		}
	}

	@Override
	public void intialize(Attack r) {
		// TODO Auto-generated method stub
		r.setSpeed(this.defensiveScale / 2);
	}

}
