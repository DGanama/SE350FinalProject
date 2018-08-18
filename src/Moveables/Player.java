package Moveables;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import Enums.MapVals;

public abstract class Player extends Moveable implements Subject {
	List<Observer> observers = new LinkedList<Observer>();
	List<Enemy> nearbyEnemies = new ArrayList<Enemy>();
	Boolean completedLevel;
	Boolean deadPlayer;
	public Player() {
		myVal = MapVals.PLAYER;
		imageView =  ImgCreator.getImage(myVal);
		completedLevel = false;
		deadPlayer = false;
		
	}
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		if(observers.contains(o))
		observers.remove(o);
	}
	@Override
	public void notifyObservers() {
		for (Observer shipObserver: observers)
			shipObserver.update(this);
	}
	@Override
	public abstract int getDamage();
	@Override
	public abstract int getMaxHealth();
	@Override
	public abstract int getNumberOfMoves();
	
	@Override
	public boolean MovementHandler(int x, int y) {
		switch(oceanMap.getVal(x, y)) {
		case CRATE:
			consumeCrate(x, y);
			return true;
		case TREASURE:
		case WIN:
			completedLevel = true;
		case OCEAN:
			return true;
		default:
			return false;
		}
	}
	public void registerNearbyEnemy(Enemy enemy) {
		nearbyEnemies.add(enemy);
	}
	public void updateNearbyEnemies() {
		ListIterator<Enemy> iter = nearbyEnemies.listIterator();
		while(iter.hasNext()){
		    if(!IsWithinRange(iter.next().getLocation())){
		        iter.remove();
		    }
		}
	}
	public boolean getCompleteStatus() {
		return completedLevel;
	}
	public boolean getDeadPlayer() {
		return deadPlayer;
	}
	public void attackNearbyEnemies() {
		for(Enemy i: nearbyEnemies) attack(i);
	}
	public void attack(Enemy target) {
		int oldHealth = target.getHealth();
		if (oldHealth - getDamage() <= 0) {
			target.setHealth(0); //Or call Terminate
			Terminate();
		}
		else target.setHealth(oldHealth - getDamage());
	}
	public void consumeCrate(int x, int y) {
		
	}
	@Override
	public void Terminate() {
		deadPlayer = true;
	}

}
