package Decorator;

import Moveables.Crate;
import Moveables.Player;

public class CrateToPowerUp {
	public PowerUpDecorator exchange(Crate c, Player S) {
		PowerUpDecorator newPowerUp = null;
		switch(c.getPowerUpType()) {
		case "AttackPower":
			newPowerUp = new AttackPower(S);
		break;
		case "HealthPower":
			newPowerUp = new HealthPower(S);
		break;
		case "MovePower":
			newPowerUp = new MovePower(S);
		break;
		
		}
		return newPowerUp;
		
	}
}
