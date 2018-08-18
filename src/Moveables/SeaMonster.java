package Moveables;

import java.awt.Point;

import ConcreteClasses.MonsterMover;
import Enums.MapVals;
import MovementStrategies.MovementStrategy;

public class SeaMonster extends Enemy {	
	int MonsterID;
	MonsterMover mMover = MonsterMover.getIns();
	public SeaMonster(int num, Point loc,  MovementStrategy pStrategy) {
		myVal = MapVals.MONSTER;
		MonsterID = num;
		strategy = pStrategy;
		patrolStrategy = pStrategy;
		currentLocation = loc.getLocation();
		PatrolCenter = loc.getLocation();
		imageView =  ImgCreator.getImage(myVal);
		updateImageViewLocation();
	}
	@Override
	public void update (Player ship){
		targetLocation = ship.getLocation();
		moveEnemy();
		if(detectPlayer()==null) {
			returnToPatrolCenter();
			updateImageViewLocation();
			setStrategy(patrolStrategy);
			ship.removeObserver(this);
			mMover.addSeaMonster(this);
			
		}
		if(IsWithinRange(ship.getLocation())) {
			attack(ship);
			ship.registerNearbyEnemy(this);
		}
		else ship.updateNearbyEnemies();
	 }
}
