package javaproject_ageOfAntHill;

import javaproject_ageOfAntHill.entity.Entity;
import javaproject_ageOfAntHill.map.Cell;
import javaproject_ageOfAntHill.map.CellState;
import javaproject_ageOfAntHill.map.Map;

public class Save {

	private String name;
	private Cell[][] grid;
	private int nbElem;

	/**
	 * 
	 * @param string
	 *            A save file like string
	 */
	public Save(String string) {
		this.grid = new Cell[Map.getNbColumn()][Map.getNbLine()];
		this.nbElem = 0;

		this.name = string.split("#####")[0];
		for (String line : string.split("#####")[1].split("####")) {
			for (String elem : line.split("###")) {
				this.grid[this.nbElem / Map.getNbColumn()][this.nbElem % Map.getNbLine()] = new Cell(
						this.entityFromStr(elem.split("##")[0]),
						CellState.getCellState(elem.split("##")[1]));
			}
		}
	}

	public Save(String name, Cell[][] grid) {
		this.name = name;
		this.grid = grid;
	}

	private Entity entityFromStr(String string) {
		
		return null;
	}

	public String getName() {
		return this.name;
	}

	public Cell[][] getSave() {
		return this.grid;
	}
	
	public String toString() {
		String ret = this.name + "#####";
		for (Cell[] column : this.grid) {
			for (Cell cell : column) {
				ret += cell.getEntity() + "##" + cell.getCellState()+"###";
			}
			ret += "####";
		}
		
		return ret;
	}
}
