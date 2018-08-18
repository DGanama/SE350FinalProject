package FReader;

import ConcreteClasses.GlobalVars;
import Enums.MapVals;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageCreator {
	Image WinLevelImage, TreasureImage, pirateShipImage, IslandImage, shipImage, MonsterImage, CrateImage;
	int scallingFactor = GlobalVars.scallingFactor;
	private static ImageCreator instance = null;
	private ImageCreator() {
		InitImages();
	}
	public void InitImages() {
		pirateShipImage = new Image("pirateShip.png",scallingFactor,scallingFactor,true,true);
		IslandImage = new Image("island.jpg",scallingFactor,scallingFactor,true,true);
		shipImage = new Image("ship.png",scallingFactor,scallingFactor,true,true);
		WinLevelImage = new Image("win.gif",scallingFactor, scallingFactor, false, false);
		MonsterImage = new Image("seaMonster.png",scallingFactor,scallingFactor,true,true);
		CrateImage = new Image("Crate.png",scallingFactor,scallingFactor,true,true);
		TreasureImage = new Image("TreasureChest.png",scallingFactor,scallingFactor,true,true);

	}
	public ImageView getImage(MapVals type) {
		ImageView toReturn;
		switch (type) {
		case PIRATE:
			toReturn= new ImageView(pirateShipImage);
			break;
		case PLAYER:
			toReturn = new ImageView(shipImage);
			break;
		case MONSTER:
			toReturn = new ImageView(MonsterImage);
			break;
		case ISLAND:
			toReturn = new ImageView(IslandImage);
			break;
		case CRATE:
			toReturn = new ImageView(CrateImage);
			break;
		case WIN:
			toReturn = new ImageView(WinLevelImage);
			break;
		default:
			toReturn = new ImageView(TreasureImage);
			}
		return toReturn;
		}
	public static ImageCreator getIns(){
		if(instance==null) {
			instance = new ImageCreator();
		}
		return instance;
		
	}
	}
