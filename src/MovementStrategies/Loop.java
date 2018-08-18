package MovementStrategies;

import java.util.ArrayList;

import Enums.enumDirections;

public class Loop extends MovementStrategy {

	public Loop()
	{
		ctr=1;
		MaxMovements=8;
		currentMovement=0;
		addPattern();
	}
	public void addPattern() {
		MovePattern=new ArrayList<enumDirections>();
		MovePattern.add(enumDirections.NORTH);
		MovePattern.add(enumDirections.WEST);
		MovePattern.add(enumDirections.SOUTH);
		MovePattern.add(enumDirections.SOUTH);
		MovePattern.add(enumDirections.EAST);
		MovePattern.add(enumDirections.EAST);
		MovePattern.add(enumDirections.NORTH);
		MovePattern.add(enumDirections.NORTH);
		MovePattern.add(enumDirections.SOUTHWEST);
		MoveM=MovePattern.iterator();
	}
	public String getStrategyName() {
		return "Patrol_Loop";
	}

}
