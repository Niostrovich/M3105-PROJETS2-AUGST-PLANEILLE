package javaproject_ageOfAntHill.entity;

/**
 * The "Scarab" class which allow to use scarab entity.
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 *
 */

public class Scarab extends Unit {

	private final static int DEFAULT_BEETLE_SPEED = 2;

	private static final int DEFAULT_HEAVY_UNIT_ARMOR = 0;

	private static final int DEFAULT_HEAVY_UNIT_DAMAGE = 0;

	private static final int DEFAULT_HEAVY_UNIT_HP = 0;
	private final static String SCARAB_TYPE = "SCAR";

	public Scarab(int teamNumber) {
		this.setRange(DEFAULT_UNIT_RANGE);
		this.setArmor(DEFAULT_HEAVY_UNIT_ARMOR);
		this.setDamages(DEFAULT_HEAVY_UNIT_DAMAGE);
		this.setMaxHealthPoints(DEFAULT_HEAVY_UNIT_HP);
		this.setHealthPoints(DEFAULT_HEAVY_UNIT_HP);
		this.setDeplacements(DEFAULT_BEETLE_SPEED);
		this.setTeam(teamNumber);
		this.setType(SCARAB_TYPE);

	}
}
