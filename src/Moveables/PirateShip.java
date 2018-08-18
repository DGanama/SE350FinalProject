package Moveables;
import java.awt.Point;
import Enums.MapVals;
import MovementStrategies.MovementStrategy;

public class PirateShip extends Enemy{ 	
	int pirateNum;
	public PirateShip(int num, Point loc, MovementStrategy pStrategy){
		myVal = MapVals.PIRATE;
		pirateNum = num;
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
		if(IsWithinRange(ship.getLocation())) {
			attack(ship);
			ship.registerNearbyEnemy(this);
		}
		else ship.updateNearbyEnemies();
		
	  }
}
