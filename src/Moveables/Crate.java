package Moveables;

import java.awt.Point;

import Enums.MapVals;


public class Crate extends MapObject{
	String power;
	public Crate(Point loc, String p) {
		currentLocation = loc.getLocation();
		power = p;
		myVal = MapVals.CRATE;
		imageView =  ImgCreator.getImage(myVal);
		updateImageViewLocation();
	}
	public String getPowerUpType() {
		return power;
	}
}
