package javaproject_ageOfAntHill.map;

/**
 * Define a cell state for the map's cells. There is 3 types of cells : the
 * yellow type : represent sand the green type : represent grass the blue type :
 * represent water
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 *
 * @version 20150526
 */

public enum CellState {
	/**
	 * This define the Yellow color of the cellState
	 */
	SAND_SQUARE("S", "SAND_SQUARE.png"),

	/**
	 * This define the Green color of the cellState
	 */
	GRASS_SQUARE("G", "GRASS_SQUARE.png"),

	/**
	 * This define the Blue color of the cellState
	 */
	WATER_SQUARE("W", "WATER_SQUARE.png"),

	/**
	 * This define the Tree Specification of the cellState
	 */
	TREE_SQUARE("T", "TREE_SQUARE.png");
	
	

	/**
	 * Name of the file (picture)
	 */
	private String fileName;
	/**
	 * state of the cell (the state can be water, grass or sand)
	 */
	private String state;
	/**
	 * true if the state is water.
	 */
	private boolean unreachable;

	/**
	 * 
	 * @param desc
	 * @param fileName
	 */
	private CellState(String initial, String fileName) {
		this.state = initial;
		this.fileName = fileName;
		this.unreachable = (initial == "W");
	}

	/**
	 * 
	 * @return the file name
	 */

	public String getFileName() {
		return this.fileName;
	}
	
	/**
	 * A case which allow you to return a Cellstate depending on his String parameter
	 * (Exemple : parameter "G" -> return "CellState.GRASS_SQUARE")
	 * @param string
	 * @return
	 */
	public static CellState getCellState(String string){
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

	/**
	 * 
	 * @return true if the cell is unreachable
	 */
	private boolean unreachable() {
		return this.unreachable;
	}

	/**
	 * Method change a CellState into a String
	 * @return state
	 */
	public String cellStateToString() {
		return this.state;
	}
}
