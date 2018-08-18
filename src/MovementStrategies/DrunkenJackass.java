package MovementStrategies;

import java.util.ArrayList;

import Enums.enumDirections;
import Moveables.Enemy;

public class DrunkenJackass extends MovementStrategy{
	final int xymax=3;
public DrunkenJackass()
{
	this.ctr=0;
	this.MaxMovements=8;
	this.currentMovement=0;
	addPattern();
	
}
	public void addPattern() {
		MovePattern=new ArrayList<enumDirections>();
		for(int x=1;x<=xymax;x++)
		{
			for(int y=0;y<x;y++)
				{
				MovePattern.add(enumDirections.EAST);
				}
			for(int y=0;y<x*2;y++)
			{
			MovePattern.add(enumDirections.WEST);
			}
			for(int y=0;y<x;y++)
			{
			MovePattern.add(enumDirections.EAST);
			}
			MoveM=MovePattern.iterator();
		}
	}
	@Override
	public void NextMove(Enemy e)
	{
		if(e.getImageView().getRotate()!=180)
		{
		e.getImageView().setRotate(180);
		}
		e.move(NextDir());
	}
	@Override
	public String getStrategyName() {
		return "Drunken_JackASS";
	}
}
