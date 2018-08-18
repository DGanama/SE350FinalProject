package LevelFactory;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Enums.*;
import FReader.Level;
import Moveables.*;
import MovementStrategies.*;

public class ConcreteLevelFactory implements LevelFactory {
	Level currentLevel;
	Random rand = new Random (4);
	public ConcreteLevelFactory(Level cLevel) {
		currentLevel = cLevel;
	}
	
	@Override
	public List<PirateShip> createPirateShips() {
		List<Point> PShipsLocations = currentLevel.getPirateShips();
		List<PirateShip> pirateShips = new ArrayList<PirateShip>();
		int num = 0;
		for (Point i: PShipsLocations) pirateShips.add(new PirateShip(num++,i.getLocation(), new Chase()));
		return pirateShips;
	}

	@Override
	public List<SeaMonster> createSeaMonster() {
		List<Point> SeaMonstersLocations = currentLevel.getSeaMonsters();
		List<SeaMonster> seaMonsters = new ArrayList<SeaMonster>();
		int num = 0;
		for (Point i: SeaMonstersLocations) seaMonsters.add(new SeaMonster(num++,i.getLocation(),getRandomStrategy()));
		return seaMonsters;
	}

	@Override
	public List<Crate> getCrates() {
		return currentLevel.getCrates();
	}
	

	@Override
	public Ship placeColumbus(Ship ship) {
		Ship columbus;
		if(ship==null)
			columbus = new Ship();
		else 
			columbus = ship;
		columbus.setLocation(currentLevel.getShipLocation());
		return columbus;
	}

	@Override
	public List<Island> createIslands() {
		List<Point> IslandPositions = currentLevel.getIslands();
		List<Island> Islands = new ArrayList<Island>();
		for (Point i: IslandPositions) Islands.add(new Island(i.getLocation()));
		return Islands;
	}
	
	public MovementStrategy getRandomStrategy() {
		PatrolPatterns patt = PatrolPatterns.values()[rand.nextInt(4)];
		switch (patt) {
		case FigureEight:
			return new FigureEight();
		case Loop:
			return new Loop();
		case DrunkenJackass:
			return new DrunkenJackass();
		case RandomReturning:
			return new RandomReturning();
		default:
			return null;
		}
		
	}

}
