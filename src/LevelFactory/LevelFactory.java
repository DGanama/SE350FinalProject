package LevelFactory;
import java.util.List;
import Moveables.*;
public interface LevelFactory {
	   public List<PirateShip> createPirateShips();
	   public List<SeaMonster> createSeaMonster();
	   public List<Crate> getCrates();
	   public Ship placeColumbus(Ship ship);
	   public List<Island> createIslands();
}
