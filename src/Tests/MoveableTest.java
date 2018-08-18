package Tests;
import ConcreteClasses.*;
import Enums.enumDirections;
import FReader.ImageCreator;

import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Point;
public class MoveableTest {
	OceanMap oceanMap = OceanMap.getIns();
	ImageCreator imgCreator = ImageCreator.getIns();
	
	@Test
	public void testMove(){
		Ship Columbus = new Ship();
		Columbus.setLocation(new Point(5,5));
		Point oldlocation = Columbus.getLocation().getLocation();
		Columbus.move(enumDirections.NORTH);
		Point newLocation = Columbus.getLocation().getLocation();
		assertFalse(oldlocation==newLocation);
	}
}
