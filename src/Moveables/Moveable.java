package Moveables;

import java.awt.Point;

import ConcreteClasses.GlobalVars;
import ConcreteClasses.OceanMap;
import Enums.MapVals;
import Enums.enumDirections;

public abstract class Moveable extends MapObject{
	int Health, MaxHealth, Damage;
	final int numMoves = 1;
	int mapX = GlobalVars.mapX;
	int mapY = GlobalVars.mapY;
	MapVals myVal;
	int scallingFactor = GlobalVars.scallingFactor;
	OceanMap oceanMap = OceanMap.getIns();
	
	public void updateOceanMap(Point loc, MapVals newVal) {
		oceanMap.updateVal(loc.x, loc.y, newVal);
	}
	
	
	public boolean IsWithinRange(Point shipLoc) {
		if (shipLoc.x>=(currentLocation.x-1) && shipLoc.x<=(currentLocation.x+1))
			if (shipLoc.y>=(currentLocation.y-1) && shipLoc.y<=(currentLocation.y+1))
				return true;
		return false;	
	}
	public abstract boolean MovementHandler(int x, int y);
	public void move(enumDirections d) {
		int i = 1;
		do {
		updateOceanMap(currentLocation, MapVals.OCEAN);
		switch(d) {
			case NORTH:
				if((currentLocation.y-1>=0) && MovementHandler(currentLocation.x, currentLocation.y-1)) currentLocation.y--;
			break;
			case SOUTH:
				if((currentLocation.y+1<mapY) && MovementHandler(currentLocation.x, currentLocation.y+1)) currentLocation.y++;
			break;
			case EAST:
				if((currentLocation.x+1<mapX) && MovementHandler(currentLocation.x+1, currentLocation.y)) currentLocation.x++;
			break;
			case WEST:
				if((currentLocation.x-1>=0) && MovementHandler(currentLocation.x-1, currentLocation.y)) currentLocation.x--;
			break;	
			case NORTHWEST:
				if((currentLocation.y-1>=0) && (currentLocation.x-1>=0) 
						&& MovementHandler(currentLocation.x-1, currentLocation.y-1)) {
					currentLocation.y--;
					currentLocation.x--;
				}

			break;
			case SOUTHEAST:
				if((currentLocation.y+1<mapY) && (currentLocation.x+1>=0) 
						&& MovementHandler(currentLocation.x+1, currentLocation.y+1)){
					currentLocation.y++;
					currentLocation.x++;
				}
			break;
			case SOUTHWEST:
				if((currentLocation.y+1<mapY) && (currentLocation.x-1>=0) 
						&& MovementHandler(currentLocation.x-1, currentLocation.y+1)){
					currentLocation.y++;
					currentLocation.x--;
				}
			break;
			default:
				if((currentLocation.y-1>=0) && (currentLocation.x+1>=0) 
						&& MovementHandler(currentLocation.x+1, currentLocation.y-1)) {
					currentLocation.y--;
					currentLocation.x++;
				}
			break;
		}
		updateImageViewLocation();
		updateOceanMap(currentLocation, myVal);
		} while (i< getNumberOfMoves());
	}
	
	
	public int getHealth() {
		return Health;
	}
	public int getDamage() {
		return Damage;
	}
	public int getMaxHealth() {
		return MaxHealth;
	}
	public int getNumberOfMoves() {
		return numMoves;
	}
	public void setHealth(int initHealth) {
		Health = initHealth;
	}
	
	public void AddHealth(int newHealth) {
		if(Health+newHealth>getMaxHealth()) Health = getMaxHealth();
		else Health+=newHealth;
		
	}

	
	public abstract void Terminate();
}
