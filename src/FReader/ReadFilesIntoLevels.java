package FReader;
import java.awt.Point;
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
public class ReadFilesIntoLevels {
	String FName;
	int objCount;
	boolean ScannerDone;
	List<Level> levels= new ArrayList<Level>();
	public ReadFilesIntoLevels(String fileName) {
		FName = fileName;
	}
	public void scanFile() {
		try {	
			Scanner sc = new Scanner(new File(FName));
			ScannerDone = false;
			objCount=0;
			while(sc.hasNextLine()) levels.add(ReadLevel(sc.nextLine()));
			sc.close();
			ScannerDone = true;
			}
		catch (Exception e) {e.printStackTrace();}
	}
	public List<Level> GetLevels(){
		return levels;
	}
	public boolean getScannerStat() {
		return ScannerDone;
	}
	public Level ReadLevel(String line) {
		//System.out.println("ReadLine into level");
		StringTokenizer LevelTokenizer = new StringTokenizer(line,";");
		if(LevelTokenizer.hasMoreTokens()) {
			objCount++;
			Level newLevel = new Level(LevelTokenizer.nextToken());
			while(LevelTokenizer.hasMoreTokens()) {
				StringTokenizer ObjectTokenizer = new StringTokenizer(LevelTokenizer.nextToken()," ");
				String name = ObjectTokenizer.nextToken();
				while(ObjectTokenizer.hasMoreTokens()) {
					String pair = ObjectTokenizer.nextToken();
					pair = pair.substring(1, pair.length()-1);
					String[] cord = pair.split(",");
					int x = Integer.parseInt(cord[0]);
					int y = Integer.parseInt(cord[1]);
					Point location = new Point(x,y);
					newLevel.addObject(name, location.getLocation());
				}
			}
			return newLevel;
		}
		return null;
	}
	
	
}
