package ConcreteClasses;
import Enums.*;
public class OceanMap {
	private static OceanMap instance = null;
	private MapVals[][] map;
	private int mapX = GlobalVars.mapX;
	private int mapY = GlobalVars.mapY;
	private OceanMap(){
		makeMap();
	}
	public void makeMap() {
		this.map=new MapVals[mapX][mapY];
		int i =0;
		int j =0;
		while(i<mapX) {
			while(j<mapY) {
				map[i][j]=MapVals.OCEAN;
				j++;
			}
			j=0;
			i++;
		}
	}
	public synchronized void updateVal(int x, int y, MapVals val) { // synchronization could be implemented here
		map[x][y]=val;
	}
	public MapVals getVal(int x, int y) {
		return map[x][y];
	}
	
	public void resetMap() {
		makeMap(); 
	}
	public static OceanMap getIns(){
		if(instance==null) {		// lazy initialization
			instance = new OceanMap();
		}
		return instance;
		
	}

}

