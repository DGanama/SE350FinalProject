package Decorator;

import Moveables.Player;

public class MovePower extends PowerUpDecorator {
	public MovePower(Player pl) {
		super(pl);
	}
	@Override
	public int getNumberOfMoves() {
		return decoratedShip.getNumberOfMoves() + 1;
	}

	@Override
	public int getMaxHealth() {
		return decoratedShip.getMaxHealth();
	}

	@Override
	public int getDamage() {
		return decoratedShip.getDamage();
	}


}
