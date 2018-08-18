package Moveables;
import java.awt.Point;

import ConcreteClasses.OceanMap;
import MovementStrategies.MovementStrategy;
import Enums.MapVals;
public abstract class Enemy extends Moveable implements Observer{
	MovementStrategy strategy, patrolStrategy;
	Point PatrolCenter;
	Point targetLocation;
	
public Point detectPlayer() {
	for(int x=(currentLocation.x-3);x<(currentLocation.x+3);x++)
		for(int y=(currentLocation.y-3);y<(currentLocation.y+3);y++)
			if(OceanMap.getIns().getVal(x, y)==MapVals.PLAYER)
				return new Point(x,y);
	return null;
}
@Override
public boolean MovementHandler(int x, int y) {
	return oceanMap.getVal(x, y) == MapVals.OCEAN;
}

public Point getTargetLocation() {
	return targetLocation.getLocation();
}
public void moveEnemy() {
	strategy.NextMove(this);
}

public void setStrategy(MovementStrategy pat)
{
	strategy=pat;
}

public void returnToPatrolCenter() {
	setLocation(PatrolCenter.getLocation());
	patrolStrategy.resetPattern();
	setStrategy(patrolStrategy);
	
}
public void attack(Player target) {
	int oldHealth = target.getHealth();
	if (oldHealth - getDamage() <= 0) target.setHealth(0); //Or call Terminate
	else target.setHealth(oldHealth - getDamage());
}
@Override
public abstract void update (Player ship);
@Override
public void Terminate() {
	oceanMap.updateVal(currentLocation.x, currentLocation.y, MapVals.OCEAN);
	}
}
