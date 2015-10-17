package javaproject_ageOfAntHill.entity;

/**
 * The "Warrior" class which allow to use warrior entity.
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */

public class Warrior extends Unit {

	private final static int DEFAULT_WARRIOR_SPEED = 3;
	private final static String WARRIOR_TYPE = "WARR";

	public Warrior(int teamNumber) {
		this.setRange(DEFAULT_UNIT_RANGE);
		this.setArmor(DEFAULT_MEDIUM_UNIT_ARMOR);
		this.setDamages(DEFAULT_MEDIUM_UNIT_DAMAGE);
		this.setMaxHealthPoints(DEFAULT_MEDIUM_UNIT_HP);
		this.setHealthPoints(DEFAULT_MEDIUM_UNIT_HP);
		this.setDeplacements(DEFAULT_WARRIOR_SPEED);
		this.setTeam(teamNumber);
		this.setType(WARRIOR_TYPE);
	}

	public void attack() {
	}

}
