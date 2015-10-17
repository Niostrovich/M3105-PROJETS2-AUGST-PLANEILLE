package javaproject_ageOfAntHill;

import javaproject_ageOfAntHill.map.InterfaceMap;
import javaproject_ageOfAntHill.map.Map;

/**
 * This class allows the user to launch the game.
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */
public class Game {
	private InterfaceMap theMap;
	private InterfaceHM interfHM;

	public Game(InterfaceHM interfHM) {
		this.interfHM = interfHM;
	}

	public void play() {
	}

	public void createGame(Displaying disp) {
		this.theMap = new Map();
		theMap.generateSandWater(disp);
		theMap.generateTree(disp);
		theMap.generateStartingUnits(disp);
		theMap.generateIAUnits(disp);
	}

	public void initGame() {
	}

	public void saveGame() {
	}

	public void leaveGame() {
	}

	public void loadGame() {
	}

	public InterfaceMap getMap() {
		return this.theMap;
	}

	public void reinitMap() {
		this.theMap = null;
	}
}
