package javaproject_ageOfAntHill.entity;

/**
 * Represents a Shooter (a special unit which can fly).
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 *
 * 
 */

public class Shooter extends Unit {
	private final static int DEFAULT_SHOOTER_SPEED = 4;
	private final static int DEFAULT_SHOOTER_RANGE = 5;
	private static final int DEFAULT_LIGHT_UNIT_ARMOR = 0;

	private static final int DEFAULT_LIGHT_UNIT_DAMAGE = 0;

	private static final int DEFAULT_LIGHT_UNIT_HP = 0;
	private final static String SHOOTER_TYPE = "SHOOT";

	public Shooter(int teamNumber) {
		this.setRange(DEFAULT_SHOOTER_RANGE);
		this.setArmor(DEFAULT_LIGHT_UNIT_ARMOR);
		this.setDamages(DEFAULT_LIGHT_UNIT_DAMAGE);
		this.setMaxHealthPoints(DEFAULT_LIGHT_UNIT_HP);
		this.setHealthPoints(DEFAULT_LIGHT_UNIT_HP);
		this.setDeplacements(DEFAULT_SHOOTER_SPEED);
		this.setTeam(teamNumber);
		this.setType(SHOOTER_TYPE);
	}

	public void tirer() {

	}

	private boolean checkRange() {
		return true;
	}

}
