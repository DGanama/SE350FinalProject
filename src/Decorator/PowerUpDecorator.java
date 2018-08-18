package Decorator;
import Moveables.Player;

public abstract class PowerUpDecorator extends Player{
	Player decoratedShip;
	public PowerUpDecorator(Player pl) {
		decoratedShip = pl;
		setLocation(pl.getLocation());
		imageView = pl.getImageView();
	}
	public abstract int getNumberOfMoves();
	
	public abstract int getMaxHealth();
		
	public abstract int getDamage();
}
