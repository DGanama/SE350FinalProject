package Decorator;

import Moveables.Player;

public class AttackPower extends PowerUpDecorator {
	public AttackPower(Player pl) {
		super(pl);
	}

	@Override
	public int getNumberOfMoves() {
		return decoratedShip.getNumberOfMoves();
	}

	@Override
	public int getMaxHealth() {
		return decoratedShip.getMaxHealth();
	}

	@Override
	public int getDamage() {
		return decoratedShip.getDamage() + 50;
	}
	
	}
