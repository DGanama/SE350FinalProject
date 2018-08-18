package Moveables;


public class Ship extends Player{
	public Ship() {
		super();
		MaxHealth = 100;
		Health = 100;
		Damage = 20;
	}
	
	@Override
	public int getDamage() {
		return Damage;
	}
	@Override
	public int getMaxHealth() {
		return MaxHealth;
	}

	@Override
	public int getNumberOfMoves() {
		return numMoves;
	}
}
