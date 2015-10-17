package javaproject_ageOfAntHill.entity.buildable;

/**
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */

public class AntHill extends Building {
	private final static String ANTHILL_TYPE = "AHILL";
	private final static int ANTHILL_HP = 1000;
	private final static int DEFAULT_ANTHILL_ARMOR = 10;

	public AntHill() {
		this.setType(ANTHILL_TYPE);
	}
}
