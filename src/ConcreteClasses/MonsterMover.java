package ConcreteClasses;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import Moveables.Player;
import Moveables.SeaMonster;
import MovementStrategies.Chase;

public class MonsterMover extends Thread {
	private static MonsterMover instance = null;
	Boolean running = true;
	Player ship;
	private List<SeaMonster> enemies = new LinkedList<SeaMonster>();
	public void addSeaMonster(SeaMonster seaMonster) {
		enemies.add(seaMonster);
		}
	public void removeSeaMonster(SeaMonster seaMonster) {
		enemies.remove(seaMonster);
		}
	public List<SeaMonster> getEnemiesPatroling(){
		
		return enemies;
		}
	public void setPlayer(Player CShip) {
		ship = CShip;
	}
	private MonsterMover() {
		
	}
	public static MonsterMover getIns(){
		if(instance==null) {
			instance = new MonsterMover();
		}
		return instance;
		
	}
	@Override
	public void run() {
		while (running) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ListIterator<SeaMonster> iter = enemies.listIterator();
			while(iter.hasNext()){
				SeaMonster nextMonster = iter.next();
			    if(nextMonster.detectPlayer()!=null){
			    		nextMonster.setStrategy(new Chase());
			    		ship.registerObserver(nextMonster);
			    		
			    		iter.remove();
			    }
			    else nextMonster.moveEnemy();
			
		    	}
		}	
	}
}