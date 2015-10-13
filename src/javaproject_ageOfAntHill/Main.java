package javaproject_ageOfAntHill;

import javax.swing.SwingUtilities;

import javaproject_ageOfAntHill.map.InterfaceMap;
import javaproject_ageOfAntHill.map.Map;

/**
 * Launching the game menu.
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 *
 * @version 20150607
 */
public class Main {
	/**
	 * The "main" of the game.
	 * 
	 * @param args
	 */
	// To check later. Eventually insert into another class.
	public static void main(String[] args) {
		InterfaceHM interfHM = new Interface();
		Displaying disp = new Displaying(interfHM);
		Menu menu = new Menu(disp);
		
		

		disp.run();
		// SwingUtilities.invokeLater(disp);
		//map.generateSandWater(disp);
		//map.generateTree(disp);
		//map.generateStartingUnits(disp);
		//map.generateIAUnits(disp);
		// Map map = new Map();
		// System.out.println("map :\n" + map.mapToString());
	}

}
