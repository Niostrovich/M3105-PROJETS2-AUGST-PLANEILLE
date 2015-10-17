package javaproject_ageOfAntHill.entity.buildable;

/**
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */
public class House extends Building {
	private final static String HOUSE_TYPE = "HOUSE";
	private final static int DEFAULT_HOUSE_HP = 250;
	private final static int DEFAULT_HOUSE_ARMOR = 20;

	public House() {
		this.setType(HOUSE_TYPE);
	}
}
