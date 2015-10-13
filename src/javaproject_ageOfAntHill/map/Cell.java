package javaproject_ageOfAntHill.map;

import javaproject_ageOfAntHill.Ressource;
import javaproject_ageOfAntHill.entity.Entity;
import javaproject_ageOfAntHill.entity.Unit;

/**
 * Class which allows to create cells
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 *
 * @version 2015/09/06
 */
public class Cell {

	/**
	 * if there is an Entity on this cell
	 */
	private Entity entity;

	/**
	 * cell's state (the state can be grass, sand or water).
	 * 
	 */
	protected CellState cellState;

	/**
	 * if a ressource is on the cell
	 */
	private Ressource ressource;
	
	/**
	 * 
	 * default constructor.
	 */
	public Cell() {
		this(null, CellState.GRASS_SQUARE);
	}

	/**
	 * Constructor with a parameter (Entity)
	 * @param entity
	 */
	public Cell(Entity entity) {
		this(entity, CellState.GRASS_SQUARE);
	}

	/**
	 * constructor with the CellState chosen
	 * 
	 * @param cellstate
	 */
	public Cell(CellState cellstate) {
		this(null, cellstate);
	}

	/**
	 * allow to create a cell with an entity and a CellState chosen
	 * 
	 * @param entity
	 * @param cellstate
	 */
	public Cell(Entity entity, CellState cellstate) {
		this.entity = entity;
		this.cellState = cellstate;
		if (cellstate == CellState.GRASS_SQUARE)
			this.ressource = new Ressource();
		else this.ressource = null;
	}

	/**
	 * 
	 * @param lineNumber
	 * @param colNumber
	 * @return
	 */
	public String cellToString(int lineNumber, int colNumber) {
		return this.cellState.cellStateToString();
	}

	/**
	 * Method to get the current State of the cell
	 * @return cellState
	 */
	public CellState getCellState() {
		return this.cellState;
	}
	
	/**
	 * Method to get the current Entity
	 * @return
	 */
	public Entity getEntity() {
		return this.entity;
	}

	/**
	 * Method to set an Entity with a type Entity
	 * @param entity
	 */
	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	/**
	 * Method to get a Unit
	 * @return unit
	 */
	public Unit getUnit() {
		return (Unit) this.entity;
	}
	
	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	public Ressource getRessource() {
		return this.ressource;
	}
}
