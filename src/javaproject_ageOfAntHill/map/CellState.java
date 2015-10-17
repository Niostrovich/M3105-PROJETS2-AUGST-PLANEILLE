package javaproject_ageOfAntHill.map;

/**
 * Define a cell state for the map's cells. There is 3 types of cells : the
 * yellow type : represent sand the green type : represent grass the blue type :
 * represent water
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 *
 */

public enum CellState {

	SAND_SQUARE("S"),

	GRASS_SQUARE("G"),

	WATER_SQUARE("W"),

	TREE_SQUARE("T");

	private String fileName;

	private String state;

	private boolean unreachable;

	private CellState(String initial) {
		this.state = initial;
		this.unreachable = (initial == "W");
	}

	public String getFileName() {
		return this.fileName;
	}

	public static CellState parseCellState(String string) {
		switch (string) {
		case "S":
			return CellState.SAND_SQUARE;
		case "G":
			return CellState.GRASS_SQUARE;
		case "W":
			return CellState.WATER_SQUARE;
		case "T":
			return CellState.TREE_SQUARE;

		default:
			return CellState.GRASS_SQUARE;
		}
	}

	private boolean unreachable() {
		return this.unreachable;
	}

	public String cellStateToString() {
		return this.state;
	}
}
