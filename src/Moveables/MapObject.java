package Moveables;

import java.awt.Point;

import ConcreteClasses.GlobalVars;
import Enums.MapVals;
import FReader.ImageCreator;
import javafx.scene.image.ImageView;

public abstract class MapObject {
	ImageCreator ImgCreator = ImageCreator.getIns();
	int scallingFactor = GlobalVars.scallingFactor;
	Point currentLocation;
	protected ImageView imageView;
	MapVals myVal;
	public Point getLocation(){
		return currentLocation;
		}
	public ImageView getImageView(){
		return imageView;
	}
	public void setLocation(Point location) {
		currentLocation = location.getLocation();
		updateImageViewLocation();
	}
	public void updateImageViewLocation() {
		imageView.setX(currentLocation.x * scallingFactor);
		imageView.setY(currentLocation.y * scallingFactor);
	}
}
