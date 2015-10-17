package javaproject_ageOfAntHill.entity;

/**
 * Represents a Queen ant in a game. Her main characteristic is to give birth to
 * other ants.
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */

public class Queen extends Unit {
	private final static int DEFAULT_QUEEN_SPEED = 0;
	private final static String QUEEN_TYPE = "QUEEN";

	public Queen(int teamNumber) {
		this.setDamages(DEFAULT_PEACEFUL_UNIT_DAMAGE);
		this.setArmor(DEFAULT_PEACEFUL_UNIT_ARMOR);
		this.setMaxHealthPoints(DEFAULT_PEACEFUL_UNIT_HP);
		this.setHealthPoints(DEFAULT_PEACEFUL_UNIT_HP);
		this.setDeplacements(DEFAULT_QUEEN_SPEED);
		this.setTeam(teamNumber);
		this.setType(QUEEN_TYPE);
	}
}
