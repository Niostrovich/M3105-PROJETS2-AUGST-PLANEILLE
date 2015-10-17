package javaproject_ageOfAntHill;

import javaproject_ageOfAntHill.map.CellState;
import javaproject_ageOfAntHill.map.InterfaceMap;
import javaproject_ageOfAntHill.map.Position;

public class Ressource {
	private final static int DEFAULT_FOOD = 0;
	private final static int DEFAULT_DIRT = 150;
	private int dirtQuantity;
	private int foodQuantity;

	public Ressource() {
		this.dirtQuantity = DEFAULT_DIRT;
		this.foodQuantity = DEFAULT_FOOD;
	}

	public void setDirtQuantity(int dirtQuantity) {
		this.dirtQuantity = dirtQuantity;
	}

	public int getDirtQuantity() {
		return this.dirtQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public int getFoodQuantity() {
		return this.foodQuantity;
	}

}
