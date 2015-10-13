package javaproject_ageOfAntHill.map;

import javaproject_ageOfAntHill.Displaying;

/**
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 *
 * @version 20150607
 */

public interface InterfaceMap {

	/**
	 * adds a defined number of water blocks randomly on the map, and fill its surroundings with sand
	 * @param disp
	 */
	public void generateSandWater(Displaying disp);
	/**
	 * adds a defined number of tree forests randomly on the map
	 * @param disp
	 */
	public void generateTree(Displaying disp);
	/**
	 * generates the player's starting units : a Queen and a Worker
	 * @param disp
	 */
	public void generateStartingUnits(Displaying disp);
	/**
	 * generate the enemy starting units : Can be a Fly, a Scarab or a Snake
	 * @param disp
	 */
	public void generateIAUnits(Displaying disp);
	/**
	 * Check if the current position is not out of the map
	 * @param position
	 * @return boolean
	 */
	public boolean notOutOfTheMap(Position position);
	/**
	 * Change the current map into a String by reseting the toString method
	 * @return String
	 */
	public String mapToString();
	/**
	 * Get the cell with a position and return a CellState
	 * @param pos
	 * @return CellState
	 */
	public Cell getCell(Position pos);
	/**
	 * returns a grid of cells representing the map
	 * @return
	 */
	public Cell[][] getGrid();

}
