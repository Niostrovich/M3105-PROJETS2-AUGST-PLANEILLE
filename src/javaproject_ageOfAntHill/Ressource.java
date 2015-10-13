package javaproject_ageOfAntHill;

import javaproject_ageOfAntHill.map.CellState;
import javaproject_ageOfAntHill.map.InterfaceMap;
import javaproject_ageOfAntHill.map.Position;

public class Ressource {
	/**
	 * initial amount of food on a cell : 0
	 */
	private final static int DEFAULT_FOOD = 0;
	/**
	 * initial amount of dirt : 150
	 */
	private final static int DEFAULT_DIRT=150;
	/**
	 * quantity of this ressource (dirt is used to create new buildings)
	 */
	private int dirtQuantity;
	/**
	 * quantity of this ressource (food is used to create new units)
	 */
	private int foodQuantity;
	
	
	/**
	 * creates the ressources in a cell with the (default) initial amounts
	 */
	public Ressource() {
		this.dirtQuantity = DEFAULT_DIRT;
		this.foodQuantity = DEFAULT_FOOD;
	}
	
	
	public void setDirtQuantity(int dirtQuantity){
		this.dirtQuantity = dirtQuantity;
	}
	
	public int getDirtQuantity(){
		return this.dirtQuantity;
	}
	
	public void setFoodQuantity(int foodQuantity){
		this.foodQuantity = foodQuantity;
	}
	
	public int getFoodQuantity(){
		return this.foodQuantity; 
	}
	
	/**
	 * use to pick up ressources(food and dirt)
	 * @return
	 */
	public Ressource pickUpRessources(Position pos, InterfaceMap map) {
//		if (map.notOutOfTheMap(pos)){
//			if (map.getCell(pos).getEntity() == null 
//			  && map.getCell(pos).getCellState() == CellState.GRASS_SQUARE){
//				if (map.getCell(pos).getRessource()!=null){
//					if (map.getCell(pos).getRessource().getType()=="FOOD"){
//						map.getCell(pos).getRessource().setQuantity(getQuantity);
//						map.getCell(pos).getRessource()==null;
//					}
//					else{
//						(Food) map.getCell(pos).getRessource().setQuantity(getQuantity);
//						map.getCell(pos).getRessource()==null;
//					}
//				}
//				
//			}
//		}
		return null;
	}
	
}
