package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import Enums.enumDirections;
import MovementStrategies.DrunkenJackass;
import MovementStrategies.FigureEight;
import MovementStrategies.Loop;
import MovementStrategies.MovementStrategy;

public class MovementStrategyTest {
	@Test
	public void testDrunkenJackassPattern(){
		MovementStrategy strat = new DrunkenJackass();
		assertFalse(strat.MovePattern.isEmpty());
	}
	
	@Test
	public void testFigureEight(){
		MovementStrategy strat = new FigureEight();
		assertTrue(strat.MovePattern.get(0)==enumDirections.NORTHWEST);
	}
	@Test
	public void testStrategyName(){
		MovementStrategy strat = new Loop();
		assertTrue(strat.getStrategyName()=="Patrol_Loop");
	}
}
