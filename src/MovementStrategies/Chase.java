package MovementStrategies;


import java.awt.Point;

import Enums.enumDirections;

public class Chase extends MovementStrategy{
	@Override
	public enumDirections NextDir() {
		Point targetLocation = currentEnemy.getTargetLocation();
		int Ydef = enemyLocation.y - targetLocation.y;
		int Xdef = enemyLocation.x - targetLocation.x;
	
		if (Xdef < 0) {
			if (Ydef < 0) 
				return enumDirections.SOUTHEAST;
			else if (Ydef > 0) 
				return enumDirections.NORTHEAST;
			else
				return enumDirections.EAST;
		}
		else if (Xdef > 0 ) {
			if (Ydef < 0) 
				return enumDirections.SOUTHWEST;
			else if (Ydef > 0) 
				return enumDirections.NORTHWEST;
			else
				return enumDirections.WEST;
		}
		else {
			if (Ydef < 0) 
				return enumDirections.NORTH;
			else  
				return enumDirections.SOUTH;
		}
	}
	@Override
	public String getStrategyName() {
		return "Chase";
	}
	
	
}
