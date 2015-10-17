package javaproject_ageOfAntHill.entity;

/**
 * represents an entity, an object in the game
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */
public abstract class Entity {
	private int healthPoints;
	private int team;
	private String type;
	private int maxHealthPoints;

	public Entity() {

	}

	public Entity(String string) {

	}

	public String getType() {
		return this.type;
	}

	public int getTeam() {
		return this.team;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void openMenu() {

	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getMaxHealthPoints() {
		return getHealthPoints();
	}

	public void setMaxHealthPoints(int maxHealthPoints) {
		this.maxHealthPoints = maxHealthPoints;
	}

	public void setTeam(int team) {
		this.team = team;
	}

}
