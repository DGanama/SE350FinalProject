package LevelFactory;
import Enums.*;
import FReader.Level;

import java.awt.Point;
import java.util.List;

import Moveables.Crate;
import Moveables.Island;
import Moveables.PirateShip;
import Moveables.SeaMonster;
import Moveables.Ship;
import ConcreteClasses.*;

public class LevelInitiator {
	Level currentLevel;
	LevelFactory levelFactory;
	OceanMap oceanMap = OceanMap.getIns();
	Ship Columbus;
	
	public LevelInitiator(Level newLevel) {
		currentLevel = newLevel;
		setFactory();
		//System.out.println("LevelInitiated");
	}
	public void setShip(Ship oldShip) {
		Columbus = oldShip;
	}
	public void initLevel(Level newLevel) {
		oceanMap.resetMap();
		currentLevel = newLevel;
		setFactory();
	}
	public List<PirateShip> getPirateShips() {
		List<PirateShip> PirateShips = levelFactory.createPirateShips();
		Point loc;
		for (PirateShip i: PirateShips) {
			loc = i.getLocation();
			oceanMap.updateVal(loc.x, loc.y, MapVals.PIRATE );
			//ImageViewBuilder.addPirateship(i);
		}
		//if (!PirateShips.isEmpty()) System.out.println("Has PirateShips");
		return PirateShips;
		
	}
	public List<SeaMonster> getSeaMonsters() {
		List<SeaMonster> SeaMonsters = levelFactory.createSeaMonster();
		Point loc;
		for (SeaMonster i: SeaMonsters) {
			loc = i.getLocation();
			oceanMap.updateVal(loc.x, loc.y, MapVals.MONSTER );
		}
		return SeaMonsters;
	}
	public List<Crate> getCrates(){
		List<Crate> Crates = levelFactory.getCrates();
		Point loc;
		for (Crate i: Crates) {
			loc = i.getLocation();
			oceanMap.updateVal(loc.x, loc.y, MapVals.CRATE );
		}
		return Crates;
	}
	public List<Island> placeIslands(){
		List<Island> Islands = levelFactory.createIslands();
		Point loc;
		for (Island i: Islands) {
			loc = i.getLocation();
			oceanMap.updateVal(loc.x, loc.y, MapVals.ISLAND );
		}
		return Islands;
	}
	public Ship placeColumbus(){
		Columbus = levelFactory.placeColumbus(Columbus);
		Point loc = Columbus.getLocation();
		oceanMap.updateVal(loc.x, loc.y, MapVals.PLAYER );
		return Columbus;
		
	}
	public void setFactory() {
		levelFactory = new ConcreteLevelFactory(currentLevel);
	}
}
