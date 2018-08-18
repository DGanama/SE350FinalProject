package MovementStrategies;

import java.util.ArrayList;
import Enums.enumDirections;

public class FigureEight extends MovementStrategy{


	public FigureEight()
	{
		ctr=1;
		MaxMovements=7;
		currentMovement=0;
		addPattern();
	}
	public void addPattern() {
		MovePattern=new ArrayList<enumDirections>();
		//LEFT LOOP
		MovePattern.add(enumDirections.NORTHWEST);
		MovePattern.add(enumDirections.SOUTHWEST);
		MovePattern.add(enumDirections.SOUTHEAST);
		MovePattern.add(enumDirections.NORTHEAST);
		//RIGHT LOOP
		MovePattern.add(enumDirections.NORTHEAST);
		MovePattern.add(enumDirections.SOUTHEAST);
		MovePattern.add(enumDirections.SOUTHWEST);
		MovePattern.add(enumDirections.NORTHWEST);
		MoveM=MovePattern.iterator();
	}
	
	/*motion pattern
	 * |       |       |       |       |       |
	 * |       |   1   |       |   5   |       |
	 * |_______|_______|_______|_______|_______|
	 * |       |       |       |       |       |
	 * |   2   |       | 0,4,8 |       |   6   |
	 * |_______|_______|_______|_______|_______|
	 * |       |       |       |       |       |
	 * |       |   3   |       |   7   |       |
	 * |_______|_______|_______|_______|_______|
	 */
	@Override
	public String getStrategyName() {
		return "Patrol_INF";
	}
}
