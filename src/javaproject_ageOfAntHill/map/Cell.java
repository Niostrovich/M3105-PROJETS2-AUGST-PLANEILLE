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
 */
public class Cell {

	private Entity entity;

	protected CellState cellState;

	private Ressource ressource;

	public Cell() {
		this(null, CellState.GRASS_SQUARE);
	}

	public Cell(Entity entity) {
		this(entity, CellState.GRASS_SQUARE);
	}

	public Cell(CellState cellstate) {
		this(null, cellstate);
	}

	public Cell(Entity entity, CellState cellstate) {
		this.entity = entity;
		this.cellState = cellstate;
		if (cellstate == CellState.GRASS_SQUARE)
			this.ressource = new Ressource();
		else
			this.ressource = null;
	}

	public String cellToString(int lineNumber, int colNumber) {
		return this.cellState.cellStateToString();
	}

	public CellState getCellState() {
		return this.cellState;
	}

	public Entity getEntity() {
		return this.entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

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
