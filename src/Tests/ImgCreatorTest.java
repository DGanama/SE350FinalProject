package Tests;
import org.junit.Test;
import static org.junit.Assert.*;

import Enums.MapVals;
import FReader.ImageCreator;
public class ImgCreatorTest {
	ImageCreator imgCreator = ImageCreator.getIns();
		
		@Test
		public void testUpdateMap(){
			imgCreator.InitImages();
			assertTrue(imgCreator.getImage(MapVals.PLAYER)!=null);
		}
}
