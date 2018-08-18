package MovementStrategies;

import java.awt.Point;
import java.util.Iterator;
import java.util.List;

import Enums.enumDirections;
import Moveables.Enemy;

public abstract class MovementStrategy {
	int MaxMovements;
	int currentMovement;
	int ctr;
	Enemy currentEnemy;
	Point enemyLocation;
	Iterator<enumDirections> MoveM;
	public List<enumDirections> MovePattern;

	public enumDirections NextDir()
	{
		if(!MoveM.hasNext())
			MoveM=MovePattern.iterator();
		ctr++;
		return MoveM.next();
	}
	public void NextMove(Enemy enemy) {
		currentEnemy = enemy;
		enemyLocation = enemy.getLocation();
		enemy.move(NextDir());
	}
	public void resetPattern() {
		MoveM = MovePattern.iterator();
	}
	public abstract String getStrategyName();
	
}
