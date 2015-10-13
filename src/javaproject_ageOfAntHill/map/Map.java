package javaproject_ageOfAntHill.map;

import java.util.Random;

import javaproject_ageOfAntHill.Displaying;
import javaproject_ageOfAntHill.LabelCustom;
import javaproject_ageOfAntHill.entity.Fly;
import javaproject_ageOfAntHill.entity.Snake;
import javaproject_ageOfAntHill.entity.Queen;
import javaproject_ageOfAntHill.entity.Scarab;
import javaproject_ageOfAntHill.entity.Worker;

/**
 * represents the map of the game
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 * @version 20150607
 */
public class Map implements InterfaceMap {
	/**
	 * A constant integer which contain the total number of lines in the grid of the game
	 */
	public final static int NBLINE = 48;
	/**
	 * A constant integer which contain the total number of columns in the grid of the game
	 */
	public final static int NBCOLUMN = 48;
	/**
	 * number of water lakes in the map
	 */
	private final static int MAX_WATER_LAKE = 8;
	/**
	 * number of tree forests in the map
	 */
	private final static int MAX_TREE_FOREST = 4;
	/**
	 * initial number of flies (enemy unit)
	 */
	private final static int MAX_FLIES_NUMBER = 15;
	/**
	 * initial number of snakes (enemy unit)
	 */
	private final static int MAX_SNAKES_NUMBER = 15;
	/**
	 * initial number of scarabs (enemy unit)
	 */
	private final static int MAX_SCARABS_NUMBER = 15;

	/**
	 * grille de jeu representant toute la carte d'une partie c'est un tableau
	 * de Position à deux dimmentions. Cette solution à été privilégiée car les
	 * cases seront toujours occupées au moins par du décor. Il n'y a aucun
	 * intérêt à stocker des positions dans un tableau à deux dimmentions, la
	 * case grille[i][j] possède déja une coordonée unique (i, j). Je propose
	 * donc de mettre un objet de type case (comme spécifié dans le diagramme de
	 * classes à mon souvenir) contenant un type de case (forêt, plaine, etc),
	 * et éventuellement une unité.
	 */
	private Cell[][] grid;


	/**
	 * creates a new map as a grid (it's a table of Cases with 2dimensions)
	 */
	public Map() {
		this.grid = new Cell[NBCOLUMN][NBLINE];
		for (int numLine = 0; numLine < NBLINE; numLine++) {
			for (int numCol = 0; numCol < NBCOLUMN; numCol++) {
				this.grid[numLine][numCol] = new Cell(); // Grass square by
															// default
			}
		}
	}

	/**
	 * adds a water block randomly on the map, and fill its surroundings with
	 * sand
	 */
	public void generateSandWater(Displaying disp) {
		for (int numWaterBlock = 0; numWaterBlock < MAX_WATER_LAKE; numWaterBlock++) {
			Random rand = new Random();
			int randNumLine = 0;
			int randNumCol = 0;
			int randNbCols = rand.nextInt(8) + 2;
			int randNbLines = rand.nextInt(9) + 2;
			boolean randValues = false;

			/*
			 * Picks a random location and checks if it is a good idea to place
			 * a water area there
			 */
			while (!randValues) {
				randNumCol = rand.nextInt(NBCOLUMN - randNbCols) + 1;
				randNumLine = rand.nextInt(NBLINE - randNbLines) + 1;
				randValues = true;
				for (int numLine = randNumLine; numLine < randNumLine + randNbLines; numLine++) {
					for (int numCol = randNumCol; numCol < randNumCol + randNbCols; numCol++) {
						if (this.grid[numLine][numCol].cellState != CellState.GRASS_SQUARE) {
							randValues = false;
						}
					}
				}
			}

			// adds a water area
			for (int numLine = randNumLine; numLine < randNumLine + randNbLines; numLine++) {
				for (int numCol = randNumCol; numCol < randNumCol + randNbCols; numCol++) {
					this.grid[numLine][numCol] = null;
					this.grid[numLine][numCol] = new Cell(CellState.WATER_SQUARE);
					LabelCustom labelFieldColor = (LabelCustom) disp.getGridOfTheGame().getComponent(getNumLabel(numLine, numCol));
					labelFieldColor.switchGroundPicture(CellState.WATER_SQUARE);
				}
			}

			int maxLine = 0;
			int maxCol = 0;
			if (randNumLine + randNbLines == NBLINE)
				maxLine = randNumLine + randNbLines;
			else
				maxLine = randNumLine + randNbLines + 1;

			if (randNumCol + randNbCols == NBCOLUMN)
				maxCol = randNumCol + randNbCols;
			else
				maxCol = randNumCol + randNbCols + 1;

			// adds Sand area around water
			for (int numLine = randNumLine - 1; numLine < maxLine; numLine++) {
				for (int numCol = randNumCol - 1; numCol < maxCol; numCol++) {
					if (this.grid[numLine][numCol].cellState != CellState.WATER_SQUARE) {
						this.grid[numLine][numCol] = null;
						this.grid[numLine][numCol] = new Cell(CellState.SAND_SQUARE);
						LabelCustom labelFieldColor = (LabelCustom) disp.getGridOfTheGame().getComponent(getNumLabel(numLine, numCol));
						labelFieldColor.switchGroundPicture(CellState.SAND_SQUARE);
					}
				}
			}
		}
	}

	/**
	 * This method add random generatly trees on the map
	 */
	public void generateTree(Displaying disp) {
		for (int nbBlockForest = 0; nbBlockForest < MAX_TREE_FOREST; nbBlockForest++) {
			Random rand = new Random();
			int randNumLine = 0;
			int randNumCol = 0;
			int randNbCols = rand.nextInt(8) + 2;
			int randNbLines = rand.nextInt(9) + 2;
			boolean randValues = false;

			/*
			 * Picks a random location and checks if it is a good idea to place
			 * a tree there
			 */
			while (!randValues) {
				randNumCol = rand.nextInt(NBCOLUMN - randNbCols);
				randNumLine = rand.nextInt(NBLINE - randNbLines);
				randValues = true;
				for (int numLine = randNumLine; numLine < randNumLine + randNbLines; numLine++) {
					for (int numCol = randNumCol; numCol < randNumCol + randNbCols; numCol++) {
						if (this.grid[numLine][numCol].cellState != CellState.GRASS_SQUARE) {
							randValues = false;
						}
					}
				}
			}

			// add a tree
			for (int numLine = randNumLine; numLine < randNumLine + randNbLines; numLine++) {
				for (int numCol = randNumCol; numCol < randNumCol + randNbCols; numCol++) {
					if (this.grid[numLine][numCol].cellState != CellState.GRASS_SQUARE) {
						this.grid[numLine][numCol] = new Cell(
								CellState.TREE_SQUARE);
					}
				}
			}

			for (int numLine = randNumLine; numLine < randNumLine + randNbLines; numLine++) {
				for (int numCol = randNumCol; numCol < randNumCol + randNbCols; numCol++) {
					this.grid[numLine][numCol] = null;
					this.grid[numLine][numCol] = new Cell(CellState.TREE_SQUARE);
					LabelCustom labelFieldColor = (LabelCustom) disp.getGridOfTheGame().getComponent(getNumLabel(numLine, numCol));
					labelFieldColor.switchGroundPicture(CellState.TREE_SQUARE);
				}
			}
		}
	}
	
	/**
	 *  generates the player's starting units : a Queen and a Worker
	 * @param disp
	 */
	public void generateStartingUnits(Displaying disp){
		for (int numLine = 0; numLine < NBLINE; numLine++) {
			for (int numCol = 0; numCol < NBCOLUMN; numCol++) {
				if (this.grid[numLine][numCol].cellState == CellState.GRASS_SQUARE 
						&& this.grid[numLine][numCol+1].cellState == CellState.GRASS_SQUARE) {
					Queen queen = new Queen(1);
					Worker worker = new Worker(1);
					this.grid[numLine][numCol].setEntity(queen);
					this.grid[numLine][numCol+1].setEntity(worker);
					disp.getFrame().getLabelTab(numLine, numCol).addEntityMap(queen);
					disp.getFrame().getLabelTab(numLine, numCol+1).addEntityMap(worker);
					return;
				}
			}
		}
	}
	
	/**
	 * Generates all the enemy units at the start of the game
	 * @param disp
	 */
	public void generateIAUnits(Displaying disp) {
		int startLine=0, startCol=0;
		// checking position of the player's starting units
		for (int numLine = 0; numLine < NBLINE; numLine++) {
			for (int numCol = 0; numCol < NBCOLUMN; numCol++) {
				if (this.grid[numLine][numCol].getEntity()!=null){
					startLine=numLine+5;	// so that there won't be any enemy within 5 lines of the player's starting units
					startCol=numCol+5;		// so that there won't be any enemy within 4 columns of the player's starting units
				}
			}
		}
		
		Random rand = new Random();
		// adds a defined number of enemy units of each type randomly in the remaining places of the map
		// adds the flies randomly on the map
		int nbEnemies = 0;
		while (nbEnemies<MAX_FLIES_NUMBER){
			rand = new Random();
			int randNbLines = rand.nextInt(NBLINE-startLine) + startLine;
			int randNbCols = rand.nextInt(NBCOLUMN);
			if (randNbLines<startLine && randNbCols<startCol)
				randNbCols = rand.nextInt(NBCOLUMN-startCol) + startCol;
			
			if (this.grid[randNbLines][randNbCols].cellState == CellState.GRASS_SQUARE 
					&& this.grid[randNbLines][randNbCols].getEntity()==null) {
				Fly fly = new Fly(2);
				this.grid[randNbLines][randNbCols].setEntity(fly);
				disp.getFrame().getLabelTab(randNbLines, randNbCols).addEntityMap(fly);
				nbEnemies++;
			}
		}
		// adds the Snakes randomly on the map
		nbEnemies=0;
		while (nbEnemies<MAX_SNAKES_NUMBER){
			rand = new Random();
			int randNbLines = rand.nextInt(NBLINE-startLine) + startLine;
			int randNbCols = rand.nextInt(NBCOLUMN);
			if (randNbLines<startLine && randNbCols<startCol)
				randNbCols = rand.nextInt(NBCOLUMN-startCol) + startCol;
			if (this.grid[randNbLines][randNbCols].cellState == CellState.GRASS_SQUARE 
					&& this.grid[randNbLines][randNbCols].getEntity()==null) {
				Snake snake = new Snake(2);
				this.grid[randNbLines][randNbCols].setEntity(snake);
				disp.getFrame().getLabelTab(randNbLines, randNbCols).addEntityMap(snake);
				nbEnemies++;
			}
		}
		// adds the scarabs randomly on the map
		nbEnemies=0;
		while (nbEnemies<MAX_SCARABS_NUMBER){
			rand = new Random();
			int randNbLines = rand.nextInt(NBLINE-startLine) + startLine;
			int randNbCols = rand.nextInt(NBCOLUMN);
			if (randNbLines<startLine && randNbCols<startCol)
				randNbCols = rand.nextInt(NBCOLUMN-startCol) + startCol;
			if (this.grid[randNbLines][randNbCols].cellState == CellState.GRASS_SQUARE 
					&& this.grid[randNbLines][randNbCols].getEntity()==null) {
				Scarab scarab = new Scarab(2);
				this.grid[randNbLines][randNbCols].setEntity(scarab);
				disp.getFrame().getLabelTab(randNbLines, randNbCols).addEntityMap(scarab);
				nbEnemies++;
			}
		}
	}
	
	/**
	 * if there is any enemy next to the unit, attack (range = 1)
	 */
	public void checkAttackOrNot() {
		
	}
	
	/*public void generateFood(Displaying disp){
		/**
		 * Init values of Lines and Cols
		 */
		/*int startLine=0;
		int startCol=0;
		
		Random rand = new Random();
		// adds a defined number of enemy units of each type randomly in the remaining places of the map
		// adds the flies randomly on the map
		int nbEnemies = 0;
		while (nbEnemies<MAX_FLIES_NUMBER){
			rand = new Random();
			int randNbLines = rand.nextInt(NBLINE-startLine) + startLine;
			int randNbCols = rand.nextInt(NBCOLUMN);
			if (randNbLines<startLine && randNbCols<startCol)randNbCols = rand.nextInt(NBCOLUMN-startCol) + startCol;
			
			if (this.grid[randNbLines][randNbCols].cellState == CellState.GRASS_SQUARE && this.grid[randNbLines][randNbCols].getEntity()==null) {
				this.grid[randNbLines][randNbCols].getRessource().getFood(150);
				disp.getJpanelLeft().addFoodValue();
				nbEnemies++;
			}
		}
	}*/
	
	/**
	 * converts a Position (x,y) into the number of a Label
	 * 
	 * @param numLine
	 * @param numCol
	 * @return the number of a Label
	 */
	public int getNumLabel(int numLine, int numCol) {
		int numLabel = 0;
		for (int lineNumber = 0; lineNumber < NBLINE; lineNumber++) {
			for (int colNumber = 0; colNumber < NBCOLUMN; colNumber++) {
				if (lineNumber == numLine && colNumber == numCol)
					return numLabel;
				numLabel++;
			}
		}
		return 0;
	}

	/**
	 * returns true if the cell is not out of the Map ; false otherwise
	 * 
	 * @param position
	 * @return
	 */
	@Override
	public boolean notOutOfTheMap(Position position) {
		if (position.getY() < 0 || position.getY() >= NBLINE
				|| position.getX() < 0 || position.getX() >= NBCOLUMN)
			return false;
		return true;
	}

	/**
	 * 
	 */
	@Override
	public Cell getCell(Position pos) {
		return this.grid[pos.getX()][pos.getY()];
	}

	/**
	 * displays a visual representation of the map (as a grid)
	 */
	@Override
	public String mapToString() {
		String mapAsciiArt = "-----------------------------------------------------------------------"
				+ "--------------------------------------------------\n";
		for (int lineNumber = 0; lineNumber < NBLINE; lineNumber++) {
			mapAsciiArt += "| ";
			for (int columnNumber = 0; columnNumber < NBCOLUMN; columnNumber++) {
				mapAsciiArt += this.grid[columnNumber][lineNumber]
						.cellToString(lineNumber, columnNumber);
				mapAsciiArt += " | ";
			}

			mapAsciiArt += "\n";
			mapAsciiArt += "-----------------------------------------------------------------------"
					+ "--------------------------------------------------\n";
		}
		return mapAsciiArt;
	}
	/**
	 * get the number into the column
	 * @return NBCOLUMN
	 */
	public static int getNbColumn() {
		return NBCOLUMN;
	}
	/**
	 * get the number into the line
	 * @return NBLINE
	 */
	public static int getNbLine() {
		return NBLINE;
	}
	/**
	 * get the grid
	 * @return grid
	 */
	public Cell[][] getGrid() {
		return this.grid;
	}

}
