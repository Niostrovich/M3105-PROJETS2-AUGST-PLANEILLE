package javaproject_ageOfAntHill.entity;

/**
 * The "Snake" class which allow to use snake entity.  
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */
public class Snake extends Unit {
	private final static int DEFAULT_SNAKE_SPEED = 3;
	private final static String SNAKE_TYPE = "SNA";

	public Snake(int teamNumber) {
		this.setRange(DEFAULT_UNIT_RANGE);
		this.setArmor(DEFAULT_MEDIUM_UNIT_ARMOR);
		this.setDamages(DEFAULT_MEDIUM_UNIT_DAMAGE);
		this.setMaxHealthPoints(DEFAULT_MEDIUM_UNIT_HP);
		this.setHealthPoints(DEFAULT_MEDIUM_UNIT_HP);
		this.setDeplacements(DEFAULT_SNAKE_SPEED);
		this.setTeam(teamNumber);
		this.setType(SNAKE_TYPE);
	}

}
