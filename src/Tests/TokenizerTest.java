package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import FReader.*;
public class TokenizerTest {
	@Test
	public void testGetLevels(){
		ReadFilesIntoLevels reader = new ReadFilesIntoLevels("src/input.txt");
		reader.scanFile(); 
		assertFalse(reader.GetLevels().isEmpty());
	}
	public void testClosedFile() {
		ReadFilesIntoLevels reader = new ReadFilesIntoLevels("src/input.txt");
		reader.scanFile(); 
		assertTrue(reader.getScannerStat());
	}
}
