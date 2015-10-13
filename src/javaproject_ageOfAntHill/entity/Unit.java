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
 */

public abstract class Unit extends Entity {
	
	protected final static int DEFAULT_UNIT_RANGE = 1;
	
	protected final static int DEFAULT_PEACEFUL_UNIT_ARMOR = 1;
	protected final static int DEFAULT_PEACEFUL_UNIT_DAMAGE = 0;
	protected final static int DEFAULT_PEACEFUL_UNIT_HP = 20;
	
	protected final static int DEFAULT_LIGHT_UNIT_ARMOR = 2;
	protected final static int DEFAULT_LIGHT_UNIT_DAMAGE = 6;
	protected final static int DEFAULT_LIGHT_UNIT_HP = 24;
	
	protected final static int DEFAULT_MEDIUM_UNIT_ARMOR = 3;
	protected final static int DEFAULT_MEDIUM_UNIT_DAMAGE = 10;
	protected final static int DEFAULT_MEDIUM_UNIT_HP = 32;
	
	protected final static int DEFAULT_HEAVY_UNIT_ARMOR = 5;
	protected final static int DEFAULT_HEAVY_UNIT_DAMAGE = 7;
	protected final static int DEFAULT_HEAVY_UNIT_HP = 30;

	
	private int armor;
	
	private int damages;
	
	private int deplacements;

	
	private int range;

	
	public Unit() {
	}

	
	public void moveUnit(Position finalPos, Position startingPos, InterfaceMap map, Window wind) {
		map.getCell(finalPos).setEntity(this);
		map.getCell(startingPos).setEntity(null);
		wind.getLabelTab(finalPos.getX(), finalPos.getY()).addEntityMap(this);
		wind.getLabelTab(startingPos.getX(), startingPos.getY()).rmvEntityMap();
	}

	
	public boolean moveAvailable(Position pos, InterfaceMap map) {
		if (map.notOutOfTheMap(pos))
			if (map.getCell(pos).getEntity() == null)
				if (map.getCell(pos).getCellState() != CellState.TREE_SQUARE
						&& map.getCell(pos).getCellState() != CellState.WATER_SQUARE)
					return true;
		return false;
	}
	
	
	public int getDamages() {
		return damages;
	}
	
	public void setDamages(int damages) {
		this.damages = damages;
	}
	
	public int getArmor() {
		return armor;
	}
	
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	public int getDeplacements() {
		return deplacements;
	}
	/
	public void setDeplacements(int deplacements) {
		this.deplacements = deplacements;
	}
	
	public int getRange() {
		return range;
	}
	
	public void setRange(int range) {
		this.range = range;
	}

}
