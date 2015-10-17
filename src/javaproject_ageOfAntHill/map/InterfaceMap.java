package javaproject_ageOfAntHill.map;

import javaproject_ageOfAntHill.Displaying;

/**
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */

public interface InterfaceMap {
	public void generateSandWater(Displaying disp);
	public void generateTree(Displaying disp);
	public void generateStartingUnits(Displaying disp);
	public void generateIAUnits(Displaying disp);
	public boolean notOutOfTheMap(Position position);
	public String mapToString();	
	public Cell getCell(Position pos);
	public Cell[][] getGrid();

}
