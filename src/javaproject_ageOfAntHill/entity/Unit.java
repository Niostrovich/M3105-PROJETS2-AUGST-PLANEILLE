package javaproject_ageOfAntHill.entity;

import javaproject_ageOfAntHill.Window;
import javaproject_ageOfAntHill.map.CellState;
import javaproject_ageOfAntHill.map.InterfaceMap;
import javaproject_ageOfAntHill.map.Position;

/**
 * represents a unit in a game this is an entity that has the capacity to move
 * and attack
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 *
 * @version 20150706
 */

public abstract class Unit extends Entity {
	// eventuellement creer une nouvelle classe (abstraite ?) pour stocker
	// toutes ces constantes
	/**
	 * default range for all units (except Shooter)
	 */
	protected final static int DEFAULT_UNIT_RANGE = 1;
	/**
	 * default armor, damages and HP for non-attacking units (queen, workers...)
	 */
	protected final static int DEFAULT_PEACEFUL_UNIT_ARMOR = 1;
	protected final static int DEFAULT_PEACEFUL_UNIT_DAMAGE = 0;
	protected final static int DEFAULT_PEACEFUL_UNIT_HP = 20;
	/**
	 * default armor, damages and HP for non-attacking units (scouts,
	 * shooters,flies...)
	 */
	protected final static int DEFAULT_LIGHT_UNIT_ARMOR = 2;
	protected final static int DEFAULT_LIGHT_UNIT_DAMAGE = 6;
	protected final static int DEFAULT_LIGHT_UNIT_HP = 24;
	/**
	 * default armor, damages and HP for medium armor units (warriors,
	 * lizards...)
	 */
	protected final static int DEFAULT_MEDIUM_UNIT_ARMOR = 3;
	protected final static int DEFAULT_MEDIUM_UNIT_DAMAGE = 10;
	protected final static int DEFAULT_MEDIUM_UNIT_HP = 32;
	/**
	 * default armor, damages and HP for heavy armor units (guardians,
	 * scarab...)
	 */
	protected final static int DEFAULT_HEAVY_UNIT_ARMOR = 5;
	protected final static int DEFAULT_HEAVY_UNIT_DAMAGE = 7;
	protected final static int DEFAULT_HEAVY_UNIT_HP = 30;

	/**
	 * The units armor : It reduce the damages taken.
	 */
	private int armor;
	/**
	 * The damages amount that the unit can inflict.
	 */
	private int damages;
	/**
	 * The unit movement range
	 */
	private int deplacements;

	/**
	 * The attack range
	 */
	private int range;

	/**
	 * new unit
	 */
	public Unit() {
	}

	/**
	 * (the tests are done before calling this function)
	 * moves the unit from a defined position to another defined position
	 */
	public void moveUnit(Position finalPos, Position startingPos, InterfaceMap map, Window wind) {
		map.getCell(finalPos).setEntity(this);
		map.getCell(startingPos).setEntity(null);
		wind.getLabelTab(finalPos.getX(), finalPos.getY()).addEntityMap(this);
		wind.getLabelTab(startingPos.getX(), startingPos.getY()).rmvEntityMap();
	}

	/**
	 * checks if the given Position is in the Map, and if there is no Entity at
	 * this Position returns true if it's 'OK' to move ; false otherwise
	 */
	public boolean moveAvailable(Position pos, InterfaceMap map) {
		if (map.notOutOfTheMap(pos))
			if (map.getCell(pos).getEntity() == null)
				if (map.getCell(pos).getCellState() != CellState.TREE_SQUARE
						&& map.getCell(pos).getCellState() != CellState.WATER_SQUARE)
					return true;
		return false;
	}
	
	/**
	 * returns the attack damages of this unit
	 * @return
	 */
	public int getDamages() {
		return damages;
	}
	/**
	 * sets the attack damages of this unit
	 * @param damages
	 */
	public void setDamages(int damages) {
		this.damages = damages;
	}
	/**
	 * returns the armor of this unit
	 * @return
	 */
	public int getArmor() {
		return armor;
	}
	/**
	 * sets the armor of this unit
	 * @param armor
	 */
	public void setArmor(int armor) {
		this.armor = armor;
	}
	/**
	 * returns the movement speed of this unit
	 * @return
	 */
	public int getDeplacements() {
		return deplacements;
	}
	/**
	 * sets the movement speed of this unit
	 * @param deplacements
	 */
	public void setDeplacements(int deplacements) {
		this.deplacements = deplacements;
	}
	/**
	 * returns the range of this unit
	 * @return
	 */
	public int getRange() {
		return range;
	}
	/**
	 * sets the range of this unit
	 * @param range
	 */
	public void setRange(int range) {
		this.range = range;
	}

}
