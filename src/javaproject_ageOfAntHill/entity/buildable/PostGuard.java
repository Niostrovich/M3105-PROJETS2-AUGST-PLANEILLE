package javaproject_ageOfAntHill.entity.buildable;

/**
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */

public class PostGuard extends Building {
	private final static String POSTGUARD_TYPE = "POSTG";
	private final static int DEFAULT_POSTGUARD_HP = 500;
	private final static int DEFAULT_POSTGUARD_ARMOR = 10;

	public PostGuard() {
		this.setType(POSTGUARD_TYPE);
	}
}
