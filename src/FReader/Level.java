package FReader;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Moveables.Crate;

public class Level {
	String levelName;
	List<Point> PirateShips = new ArrayList<Point>();
	List<Point> SeaMonsters = new ArrayList<Point>();
	List<Point> Islands = new ArrayList<Point>();
	List<Crate> powerUps = new ArrayList<Crate>();
	Point columbus;
	int numPirateShips, numSeaMonsters = 0;
	public Level(String lname) {
		levelName = lname;
	}
	public void addObject(String name, Point location) {
		switch(name) {
		case "PirateShip":
			PirateShips.add( location.getLocation() );
		break;
		case "Ship":
			columbus = location.getLocation() ;
		break;
		case "SeaMonster":
			SeaMonsters.add(location.getLocation() );

		break;
		case "Island":
			Islands.add(location.getLocation());
		break;
		default:
			powerUps.add(new Crate(location.getLocation(),name));
		break;
		}
		
	}
	public List<Point> getPirateShips(){
		return PirateShips;
	}
	public List<Point> getSeaMonsters(){
		return SeaMonsters;
	}
	public List<Point> getIslands(){
		return Islands;
	}
	@Override
	public String toString() {
		return levelName;
	}
	public Point getShipLocation() {
		return columbus;
	}
	public List<Crate> getCrates(){
		return powerUps;
	}
}
