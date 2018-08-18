package Tests;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

import ConcreteClasses.GlobalVars;
import ConcreteClasses.OceanMap;
import Enums.MapVals;
public class OceanMapTests {
	private int mapX = GlobalVars.mapX;
	private int mapY = GlobalVars.mapY;
	Random rand;
	
	@Test
	public void testUpdateMap(){
		OceanMap oceanMap = OceanMap.getIns();
		rand = new Random(50);
		int x = rand.nextInt(mapX);
		int y = rand.nextInt(mapY);
		MapVals oldVal = oceanMap.getVal(x, y);
		oceanMap.updateVal(x, y, MapVals.MONSTER);
		MapVals newVal = oceanMap.getVal(x, y);
		assertFalse(oldVal == newVal);
	}
	
	@Test
	public void testUnique(){
		OceanMap oceanMap1 = OceanMap.getIns();
		OceanMap oceanMap2 = OceanMap.getIns();
		assertTrue(oceanMap1==oceanMap2);
	}
	@Test
	public void testResetMap(){
		OceanMap oceanMap = OceanMap.getIns();
		oceanMap.updateVal(5, 5, MapVals.ISLAND);
		oceanMap.resetMap();
		assertTrue(oceanMap.getVal(5, 5)==MapVals.OCEAN);
	}
}
