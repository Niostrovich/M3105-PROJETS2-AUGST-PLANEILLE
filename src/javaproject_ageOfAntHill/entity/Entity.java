package javaproject_ageOfAntHill.entity;

/**
 * represents an entity, an object in the game
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 * 
 * @version 20150526
 */
public abstract class Entity {
	/**
	 * defined the healPoints of a unity
	 */
	private int healthPoints;
	/**
	 * defined the Maximum Health Points of a unity
	 */
	private int maxHealthPoints;
	/**
	 * defined the Team of an entity
	 */
	private int team;
	/**
	 * defines the Entity's type (Warrior, Fly, AntHill, ...)
	 */
	private String type;
	
	/**
	 * creates a new Entity corresponding to a new in-game object (unit,
	 * building...)
	 */
	public Entity() {

	}
	
	public Entity(String string){
		
	}
	
	public String getType(){
		return this.type;
	}
	
	public int getTeam(){
		return this.team;
	}
	
	public void setType(String type){
		this.type=type;
	}
	
	/**
	 * open the menu with the different available options for this entity
	 */
	public void openMenu() {

	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getMaxHealthPoints() {
		return maxHealthPoints;
	}

	public void setMaxHealthPoints(int maxHealthPoints) {
		this.maxHealthPoints = maxHealthPoints;
	}

	public void setTeam(int team) {
		this.team = team;
	}

}
