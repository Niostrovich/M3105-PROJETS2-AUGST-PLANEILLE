package javaproject_ageOfAntHill.entity;

/**
 * Represents a Shooter (a special unit which can fly).
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 *
 * @version 20150526
 */

public class Shooter extends Unit {
	/**
	 * Shooter's default movement speed.
	 */
	private final static int DEFAULT_SHOOTER_SPEED = 4;
	/**
	 * Shooter's default attack range.
	 */
	private final static int DEFAULT_SHOOTER_RANGE = 5;
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
	 * Just like a serial name, it's used to identify a shooter's type.
	 */
	private final static String SHOOTER_TYPE = "SHOOT";

	/**
	 * That creates a Shooter with its default stats.
	 */
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

	/**
	 * Attacks the enemy if this is possible (if he's in range to attack) if
	 * the enemy is hit, he will loose (shooter's damages - enemy's armor) health point.
	 */
	public void tirer() {

	}

	/**
	 * Return true if the target is in the attack range of the shooter ; false
	 * otherwise.
	 */
	private boolean checkRange() { // eventuellement supprimer cette méthode en
									// l'insérant dans la méthode tirer()
		return true;
	}

}
