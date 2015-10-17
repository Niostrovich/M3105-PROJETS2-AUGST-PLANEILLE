package javaproject_ageOfAntHill.entity;

import javax.swing.ImageIcon;

/**
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */

public class Fly extends Unit {
	private final static int DEFAULT_FLY_SPEED = 6;
	private final static String FLY_TYPE = "FLY";
	private static final int DEFAULT_LIGHT_UNIT_ARMOR = 0;
	private static final int DEFAULT_LIGHT_UNIT_DAMAGE = 0;
	private static final int DEFAULT_LIGHT_UNIT_HP = 0;

	public Fly(int teamNumber) {
		this.setRange(DEFAULT_UNIT_RANGE);
		this.setArmor(DEFAULT_LIGHT_UNIT_ARMOR);
		this.setDamages(DEFAULT_LIGHT_UNIT_DAMAGE);
		this.setMaxHealthPoints(DEFAULT_LIGHT_UNIT_HP);
		this.setHealthPoints(DEFAULT_LIGHT_UNIT_HP);
		this.setDeplacements(DEFAULT_FLY_SPEED);
		this.setTeam(teamNumber);
		this.setType(FLY_TYPE);

	}
}
