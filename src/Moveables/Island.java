package Moveables;

import java.awt.Point;

import Enums.MapVals;


public class Island extends MapObject {
	public Island(Point loc) {
		currentLocation = loc.getLocation();
		myVal = MapVals.ISLAND;
		imageView =  ImgCreator.getImage(myVal);
		updateImageViewLocation();
	}
}
