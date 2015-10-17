package javaproject_ageOfAntHill.entity.buildable;

/**
 * represents a Building used when creating new building
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */
public abstract class Building extends Buildable {

	public static int healthPoints = 10;

	public static int maxHealthPoints = 10; // we need to think about this value

	protected int team;
	public static int armor = 3;

	public Building() {
		this.healthPoints = healthPoints;
		this.maxHealthPoints = maxHealthPoints;
		this.armor = armor;
	}

	public Building(int health, int maxHealth) {
		this.healthPoints = health;
		this.maxHealthPoints = maxHealth;
	}

}