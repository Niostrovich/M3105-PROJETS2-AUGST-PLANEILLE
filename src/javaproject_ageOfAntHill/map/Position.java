package javaproject_ageOfAntHill.map;

/**
 * represents a case at given (x,y) coordinates
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */
public class Position {

	private int x;

	private int y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Position(int positionX, int positionY) {
		this.x = positionX;
		this.y = positionY;
	}

	public boolean moveAvailable(int positionX, int positionY) {
		return true;
	}

}
