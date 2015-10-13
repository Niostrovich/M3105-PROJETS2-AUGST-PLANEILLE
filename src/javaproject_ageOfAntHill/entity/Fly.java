package javaproject_ageOfAntHill.entity;

/**
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 * 
 * @version 20150526
 */

public class Fly extends Unit {
	/**
	 * A fly's movement speed. 
	 */
	private final static int DEFAULT_FLY_SPEED = 6;
	/**
	 * Just like a serial name, it's used to identify a fly's type.
	 */
	private final static String FLY_TYPE = "FLY";
	/**
	 * Default armor
	 */
	//TODO
	private static final int DEFAULT_LIGHT_UNIT_ARMOR = 0;

	/**
	 * Default damages.
	 */
	//TODO
	private static final int DEFAULT_LIGHT_UNIT_DAMAGE = 0;

	/**
	 * Default health. 
	 */
	//TODO
	private static final int DEFAULT_LIGHT_UNIT_HP = 0;
	
	/**
	 * That creates a fly with all its default stats values.
	 */
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
