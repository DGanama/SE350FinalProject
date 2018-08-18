package ConcreteClasses;
import java.util.List;
import Enums.*;
import FReader.*;
import LevelFactory.LevelInitiator;
import Moveables.Crate;
import Moveables.Island;
import Moveables.PirateShip;
import Moveables.SeaMonster;
import Moveables.Ship;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;



public class OceanExplorer extends Application{
	final private int scallingFactor = GlobalVars.scallingFactor;  
	final private int mapX = GlobalVars.mapX;
	final private int mapY = GlobalVars.mapY;
	OceanMap oceanMap = OceanMap.getIns();
	List<Level> levels;
	List<PirateShip> pirates;
	List<SeaMonster> seaMonsters;
	List<Island> Islands;
	List<Crate> Crates;
	LevelInitiator runningLevel;
	Drawing drawing;
	Scene scene;
	PaneManager paneManager = PaneManager.getIns();
	Stage theStage;
	int LevelInd;
	Ship Columbus;
	MapVals[][] OceanGrid;
	//Thread MonsterThread;
	MonsterMover monsterMover;
	
	
	public void restartGame() {
		LevelInd=0;
		StartupTools();
		theStage.setScene(scene);
	}
	public void startLevel() {
		if(LevelInd==0) runningLevel = new LevelInitiator(levels.get(0));
		else runningLevel.initLevel(levels.get(LevelInd));
		Columbus = runningLevel.placeColumbus();
		pirates = runningLevel.getPirateShips();
		for (PirateShip i: pirates) Columbus.registerObserver(i);
		seaMonsters = runningLevel.getSeaMonsters();
		Crates = runningLevel.getCrates();
		Islands = runningLevel.placeIslands();
	}
	public void addButton() {
		Button button = new Button("Reset");
		button.setScaleX(1.5);
		button.setScaleY(2);
		button.setLayoutX(mapX*scallingFactor+12.5);
		button.setLayoutY(280);
		button.setOnAction(new EventHandler<ActionEvent>() {
		@Override
	    	public void handle(ActionEvent ke) {
		 		try {
					restartGame();
				} catch (Exception e) {
					e.printStackTrace();
				}
		 	}
		});
		paneManager.addChild(button);
	}
	public void StartupTools() {
		paneManager.setPane(new Pane());
		scene = new Scene(paneManager.getPane(),mapX*scallingFactor+80,mapY*scallingFactor);
		drawing = new Drawing(paneManager.getPane());
		startLevel();
		startGame();
		drawing.drawMap();
		addImageViews();
		//addButton();
		
	}
	public void LevelChanger() {
		runningLevel.setShip(Columbus);
		LevelInd++;
		StartupTools();
		theStage.setScene(scene);
	}
	public void addImageViews() {
		paneManager.addChild(Columbus.getImageView());
		for(PirateShip i: pirates) paneManager.addChild(i.getImageView());
		for(SeaMonster i: seaMonsters) paneManager.addChild(i.getImageView());
		for(Island i: Islands) paneManager.addChild(i.getImageView());
		for(Crate i: Crates) paneManager.addChild(i.getImageView());
	}
	
	@Override
	public void start(Stage oceanStage) throws Exception{
		ReadFilesIntoLevels reader = new ReadFilesIntoLevels("src/input.txt");
		reader.scanFile();
		levels = reader.GetLevels();
		oceanStage.setTitle("ColumbusGame");
		StartupTools();
		oceanStage.setScene(scene);
		oceanStage.show();
		theStage = oceanStage;
		monsterMover = MonsterMover.getIns();
		monsterMover.setPlayer(Columbus);
		for(SeaMonster i: seaMonsters) monsterMover.addSeaMonster(i);
		
//		MonsterThread = new Thread(monsterMover);
		monsterMover.start();
		
		/*ToolBar toolBar = new ToolBar(
			     new ImageView()
			     new Separator(),
			     new Button("Clean"),
			     new Button("Compile"),
			     new Button("Run"),
			     new Separator(),
			     new Button("Debug"),
			     new Button("Profile")
			 );
		toolBar.setOrientation(Orientation.VERTICAL);
		toolBar.setLayoutX(mapX * scallingFactor);
		toolBar.setLayoutY(0);
		root.getChildren().add(toolBar);*/
	}
	@SuppressWarnings("deprecation")
	@Override
	public void stop(){
		monsterMover.stop();
	}
	private void startGame(){
	    scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
	    	@Override
	    	public void handle(KeyEvent ke) {
	    		switch(ke.getCode()){
			    		case D:
			    			Columbus.move(enumDirections.EAST);						
			    			break;
			    		case A:
			    			Columbus.move(enumDirections.WEST);
			    			break;
			    		case S:
			    			Columbus.move(enumDirections.SOUTH);
			    			break;
			    		case W:
			    			Columbus.move(enumDirections.NORTH);
			    			break;
			    		case E:
				    		Columbus.move(enumDirections.NORTHEAST);						
				    		break;
				    	case Q:
				    		Columbus.move(enumDirections.NORTHWEST);
				    		break;
				    	case Z:
				    		Columbus.move(enumDirections.SOUTHWEST);
				    		break;
				    	case X:
				    		Columbus.move(enumDirections.SOUTHEAST);
				    		break;
				    	case SPACE:
				    		Columbus.attackNearbyEnemies();
				    		//LevelChanger();
				    		break;
			    	    default:
			    		break;	
	    			}
	    		//if()
	    		Columbus.notifyObservers();
	    			}
	    		}
	    	);
	    }    
		
	public static void main(String[] args) {
		launch(args);
		
	}
}
