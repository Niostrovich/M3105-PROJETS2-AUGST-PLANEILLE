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


	SAND_SQUARE("S", "SAND_SQUARE.png"),



	GRASS_SQUARE("G", "GRASS_SQUARE.png"),



	WATER_SQUARE("W", "WATER_SQUARE.png"),



	TREE_SQUARE("T", "TREE_SQUARE.png");
	
	
	private String fileName;


	private String state;


	private boolean unreachable;

	private CellState(String initial, String fileName) {
		this.state = initial;
		this.fileName = fileName;
		this.unreachable = (initial == "W");
	}




	public String getFileName() {
		return this.fileName;
	}
	


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

	
	private boolean unreachable() {
		return this.unreachable;
	}

	
	public String cellStateToString() {
		return this.state;
	}
}
