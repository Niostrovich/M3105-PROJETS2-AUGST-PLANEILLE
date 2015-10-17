package javaproject_ageOfAntHill.entity;

/**
 * The "Worker" class which allow to use worker entity.  
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */
import javaproject_ageOfAntHill.entity.buildable.Building;

public class Worker extends Unit {
	private final static int DEFAULT_WORKER_SPEED = 4;
	private final static String WORKER_TYPE = "WORK";
	private static final int DEFAULT_LIGHT_UNIT_ARMOR = 0;

	private static final int DEFAULT_LIGHT_UNIT_DAMAGE = 0;

	private static final int DEFAULT_LIGHT_UNIT_HP = 0;

	public Worker(int teamNumber) {
		this.setDamages(DEFAULT_PEACEFUL_UNIT_DAMAGE);
		this.setArmor(DEFAULT_PEACEFUL_UNIT_ARMOR);
		this.setMaxHealthPoints(DEFAULT_PEACEFUL_UNIT_HP);
		this.setHealthPoints(DEFAULT_PEACEFUL_UNIT_HP);
		this.setDeplacements(DEFAULT_WORKER_SPEED);
		this.setTeam(teamNumber);
		this.setType(WORKER_TYPE);
	}

	public void construire(Building thisBuilding) {
	}

}
