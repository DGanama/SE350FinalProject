package Decorator;

import Moveables.Player;


public class HealthPower extends PowerUpDecorator{
	public HealthPower(Player pl) {
		super(pl);
	}
	@Override
	public int getNumberOfMoves() {
		return decoratedShip.getNumberOfMoves();
	}

	@Override
	public int getMaxHealth() {
		return decoratedShip.getMaxHealth()+100;
	}

	@Override
	public int getDamage() {
		return decoratedShip.getDamage();
	}
}
