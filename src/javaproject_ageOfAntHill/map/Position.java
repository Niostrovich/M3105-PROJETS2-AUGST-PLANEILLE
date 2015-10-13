package javaproject_ageOfAntHill.map;

/**
 * represents a case at given (x,y) coordinates
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 *
 * @version 20150526
 */
public class Position {
	/**
	 * abscissa of the case
	 */
	private int x;

	/**
	 * ordered of the case
	 */
	private int y;

	/**
	 * Get the abscissa of the case
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get the ordered of the case
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * constructs a new case at given coordinates
	 */
	public Position(int positionX, int positionY) {
		this.x = positionX;
		this.y = positionY;
	}

	/**
	 * returns false if there is an entity at the given cooridnates
	 * (positionX,positionY) ; true otherwise
	 */
	public boolean moveAvailable(int positionX, int positionY) {
		return true;
	}

}
