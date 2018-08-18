package FReader;

import java.util.*;

import ConcreteClasses.*;
import Moveables.Moveable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Drawing {
	Pane root;
	int mapY = GlobalVars.mapY;
	int mapX = GlobalVars.mapX;
	int scallingFactor = GlobalVars.scallingFactor;
	OceanMap oceanMap = OceanMap.getIns();
	public Drawing(Pane p) {
		this.root = p;
	}
	public void drawMap() {
		for (int x = 0; x < mapX; x++) {
			for (int y = 0; y < mapY; y++) {				
					root.getChildren().add(drawRectangles(x,y));			
			}
		}
	}
	
	public Rectangle drawRectangles(int x, int y) {
		Rectangle rect = new Rectangle(x * scallingFactor, y * scallingFactor, scallingFactor, scallingFactor);
		rect.setStroke(Color.BLACK);
		switch (oceanMap.getVal(x, y)) {
			case ISLAND:
				rect.setFill(Color.LIGHTGREEN);
				break;
			default:
				rect.setFill(Color.LIGHTBLUE);
				break;
		}
		return rect;
	}
	public void drawObjects(List<Moveable> l) {
		 for(Moveable m : l) {
			 drawObj(m);
		 }
		
	}
	public void drawObj(Moveable m) {
		root.getChildren().add(m.getImageView());
		
	}
}
