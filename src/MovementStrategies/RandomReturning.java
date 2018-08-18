package MovementStrategies;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import Enums.enumDirections;
import java.util.Random;
public class RandomReturning extends MovementStrategy {
List<enumDirections> fwd;
List<enumDirections> rev;
final int MaxMoves=3;
	public RandomReturning()
	{
ctr=0;
		fwd=new ArrayList<enumDirections>();
		rev=new ArrayList<enumDirections>();
		MovePattern=new ArrayList<enumDirections>();
		MoveM=MovePattern.iterator();
	};
	private enumDirections Opposite(enumDirections dir)
	{
		switch(dir)
		{
		case SOUTH:
			return enumDirections.NORTH;
		case NORTH:
			return enumDirections.SOUTH;
		case EAST:
			return enumDirections.WEST;
		case WEST:
			return enumDirections.EAST;
		case NORTHWEST:
			return enumDirections.SOUTHEAST;
		case NORTHEAST:
			return enumDirections.SOUTHWEST;
		case SOUTHWEST:
			return enumDirections.NORTHEAST;
		case SOUTHEAST:
			return enumDirections.NORTHWEST;
		default:
				return null;
		}
	}

public void updatePattern()
{
	fwd=new ArrayList<enumDirections>();
	rev=new ArrayList<enumDirections>();
	MovePattern=new ArrayList<enumDirections>();
	MovePattern.clear();
	forwardPattern();
	backwardPattern();
	MovePattern.addAll(fwd);
	MovePattern.addAll(rev);
	MoveM=MovePattern.iterator();

}
private void forwardPattern()
{
	int ctr=0;
	enumDirections oldDir;
	enumDirections dir;
	Random rnd = new Random();
	dir =enumDirections.values()[rnd.nextInt(8)];
	fwd.add(dir);
	oldDir=dir;
	while(ctr<MaxMoves-1)
	{
		dir =enumDirections.values()[rnd.nextInt(8)];
		if(dir!=Opposite(oldDir))
		{
			fwd.add(dir);
			oldDir=dir;
			ctr++;
		}
	}
}
private void backwardPattern()
{
	Iterator<enumDirections> itDir=fwd.iterator();
	while(itDir.hasNext())
	{
		rev.add(Opposite(itDir.next()));
	}
	Collections.reverse(rev);
}
@Override
public enumDirections NextDir()
{
	if(!MoveM.hasNext())
	{
		ctr=0;
		updatePattern();
		MoveM=MovePattern.iterator();

	}
	else 
	{
		ctr++;
	}
	return MoveM.next();
}
@Override
public String getStrategyName() {
	
	return "RandomReturning";
}
}
