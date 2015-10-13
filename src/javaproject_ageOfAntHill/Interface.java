package javaproject_ageOfAntHill;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import javaproject_ageOfAntHill.entity.Entity;
import javaproject_ageOfAntHill.entity.Unit;
import javaproject_ageOfAntHill.entity.buildable.AntHill;
import javaproject_ageOfAntHill.entity.buildable.Building;
import javaproject_ageOfAntHill.entity.buildable.House;
import javaproject_ageOfAntHill.entity.buildable.PostGuard;
import javaproject_ageOfAntHill.map.CellState;
import javaproject_ageOfAntHill.map.InterfaceMap;
import javaproject_ageOfAntHill.map.Map;
import javaproject_ageOfAntHill.map.Position;

/**
 * Class for an interface of the game.
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 *
 * @version 20150607
 */
public class Interface implements InterfaceHM, MouseListener, ActionListener, KeyListener {	
	/**
	 * 	value changing according to the situation: 
	 * 		=> 0 when no selected unit;
	 * 		=> 1 when waiting for the end cell of group selection
	 * 		=> 2 when 1 (or more) unit is selected; 
	 * 		=> 3 when the destination cell has been selected
	 * 		=> check if there is a fight ? then => 0
	 */
	private volatile int clickState;
	/**
	 * value of the current state of the key listeners events
	 * 0 => no key pressed
	 * 1 => user already chose b (for building) => then he needs to select a type of building to build
	 */
	private volatile int keyState;
	/**
	 * temporary selected cell
	 */
	private LabelCustom lab;
	/**
	 * used to store the current selected unit(s)
	 */
	private LinkedList<Unit> units;
	/**
	 * event of the last selection
	 */
	private MouseEvent event;
	/**
	 * corresponds to the selected building
	 */
	private Building building;
	/**
	 * corresponds to the current position of the selected building
	 */
	private Position buildingPos;
	/**
	 * used to store the current position of selected unit(s)
	 */
	private LinkedList<Position> unitsPos;
	/**
	 * window of the game
	 */
	private Window wind;
	/**
	 * used to store a position (used to create a new building)
	 */
	private Position creatingPos;
	/**
	 * corresponds to the grid of the map
	 */
	private InterfaceMap map;
	
	/**
	 * creates new interface with all attributes non-existent
	 */
	public Interface(){
		this.units = new LinkedList<Unit>();
		this.unitsPos = new LinkedList<Position>();
		this.building = null;
		this.buildingPos = null;
		this.wind = null;
		this.lab = null;
		this.event = null;
		this.creatingPos = null;
		this.map = null;
		clickState = 0;
		keyState = 0;
	}
	
	/**
	 * Allow the player to select a group of units
	 * @param e 
	 */
	public void selectUnits(LabelCustom labelUnit1, LabelCustom labelUnit2, MouseEvent e) {
		int numLabel1=0;
		int numLabel2=0;
		this.event=e;	// store this event in order to call it back later (when unselecting units)
		// store the number of the labels 1 and 2
		for (int numLabel=0;numLabel<Map.NBCOLUMN*Map.NBLINE;numLabel++){
			if (labelUnit1==(LabelCustom) e.getComponent().getParent().getComponent(numLabel)){
				numLabel1=numLabel;
			}
			if (labelUnit2==(LabelCustom) e.getComponent().getParent().getComponent(numLabel)){
				numLabel2=numLabel;
			}
		}
		
		int team = labelUnit1.getLabEntity().getTeam();		// only select units of the same team as the first selected one
		
		
		
		this.addUnits(numLabel1/Map.NBLINE, numLabel2/Map.NBLINE, numLabel1%Map.NBCOLUMN, numLabel2%Map.NBCOLUMN, e, team);
		
		addPictureSelection();
		
	}
	
	/**
	 * adds all the units in the field range inside the units collection
	 * @param numLine1
	 * @param numLine2
	 * @param numCol1
	 * @param numCol2
	 * @param e
	 */
	private void addUnits(int numLine1, int numLine2, int numCol1, int numCol2, MouseEvent e, int team){
		int lineNumber;
		int colNumber;
			// gets the window of the game through this component's event
		
		if (numLine1 <= numLine2 && numCol1 <= numCol2){
			for (lineNumber = numLine1 ; lineNumber <= numLine2 ; lineNumber++){
				for (colNumber = numCol1 ; colNumber <= numCol2 ; colNumber++){
					if (wind.getLabelTab(lineNumber, colNumber).getLabEntity() != null 
							&& team == wind.getLabelTab(lineNumber, colNumber).getLabEntity().getTeam()){
						Entity ent = wind.getLabelTab(lineNumber, colNumber).getLabEntity();
						Position pos = new Position(lineNumber, colNumber);
						this.unitsPos.add(pos);
						this.units.add((Unit) ent);
					}
				}
			}
		}
		else {
			if (numLine1 <= numLine2 && numCol1 > numCol2){
				for (lineNumber = numLine1 ; lineNumber <= numLine2 ; lineNumber++){
					for (colNumber = numCol2 ; colNumber <= numCol1 ; colNumber++){
						if (wind.getLabelTab(lineNumber, colNumber).getLabEntity() != null 
								&& team == wind.getLabelTab(lineNumber, colNumber).getLabEntity().getTeam()){
							Entity ent = wind.getLabelTab(lineNumber, colNumber).getLabEntity();
							Position pos = new Position(lineNumber, colNumber);
							this.unitsPos.add(pos);
							this.units.add((Unit) ent);
						}
					}
				}
			}
			else {
				if (numLine1 > numLine2 && numCol1 <= numCol2){
					for (lineNumber = numLine2 ; lineNumber <= numLine1 ; lineNumber++){
						for (colNumber = numCol1 ; colNumber <= numCol2 ; colNumber++){
							if (wind.getLabelTab(lineNumber, colNumber).getLabEntity() != null 
									&& team == wind.getLabelTab(lineNumber, colNumber).getLabEntity().getTeam()){
								Entity ent = wind.getLabelTab(lineNumber, colNumber).getLabEntity();
								Position pos = new Position(lineNumber, colNumber);
								this.unitsPos.add(pos);
								this.units.add((Unit) ent);
							}
						}
					}
				}
				else {
					for (lineNumber = numLine2 ; lineNumber <= numLine1 ; lineNumber++){
						for (colNumber = numCol2 ; colNumber <= numCol1 ; colNumber++){
							if (wind.getLabelTab(lineNumber, colNumber).getLabEntity() != null 
									&& team == wind.getLabelTab(lineNumber, colNumber).getLabEntity().getTeam()){
								Entity ent = wind.getLabelTab(lineNumber, colNumber).getLabEntity();
								Position pos = new Position(lineNumber, colNumber);
								this.unitsPos.add(pos);
								this.units.add((Unit) ent);
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * changes picture selection unit/building
	 */
	private void addPictureSelection() {
		if (this.units != null){
			for (int numUnit= 0; numUnit < this.units.size(); numUnit++){
				int line = this.unitsPos.get(numUnit).getX();
				int col = this.unitsPos.get(numUnit).getY();
				switch (this.units.get(numUnit).getType()){
				case "FLY":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/fly/flySelect.png"));
					break;
				case "GUARD":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/guardian/guardianSelect.png"));
					break;
				case "SNA":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/snake/snakeSelect.png"));
					break;
				case "QUEEN":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/queen/queenSelect.png"));
					break;
				case "SCAR":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/scarab/scarabSelect.png"));
					break;
				case "SCOUT":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/scout/scoutSelect.png"));
					break;
				case "SHOOT":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/shooter/shooterSelect.png"));
					break;
				case "WARR":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/warrior/warriorSelect.png"));
					break;
				case "WORK":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/worker/workerSelect.png"));
					break;
				default:
				}
			}
				// displays the unit's hp in case only one unit was selected
			if (this.units.size()==1){
				wind.getDisp().getJpanelLeft().selectionEntity(this.units.get(0));
				wind.getDisp().getJpanelLeft().setHp(this.units.get(0).getHealthPoints(), this.units.get(0).getMaxHealthPoints());
				wind.getDisp().getJpanelLeft().setArmor(this.units.get(0).getArmor());
			}
			else
				wind.getDisp().getJpanelLeft().selectionEntity(this.units.get(0).getTeam());
		}
		else if (this.building != null){
			switch (this.building.getType()){
			case "AHILL":
				wind.getLabelTab(this.buildingPos.getX(), this.buildingPos.getY()).getJlentity().setIcon(new ImageIcon("./img/buildings/ANTHILL_BUILDING.png"));
				break;
			case "HOUSE":
				wind.getLabelTab(this.buildingPos.getX(), this.buildingPos.getY()).getJlentity().setIcon(new ImageIcon("./img/buildings/HOUSE_BUILDING.png"));
				break;
			case "POSTGUARD":
				wind.getLabelTab(this.buildingPos.getX(), this.buildingPos.getY()).getJlentity().setIcon(new ImageIcon("./img/buildings/POSTGUARD_BUILDING.png"));
				break;
			default:
			}
			wind.getDisp().getJpanelLeft().setHp(this.building.getHealthPoints(), this.building.getMaxHealthPoints());
			wind.getDisp().getJpanelLeft().setArmor(0); // buildings have no armor
		}
	}
	
	/**
	 * changes picture unselection unit/building
	 */
	private void addPictureUnselection() {
		if (this.units != null){
			for (int numUnit= 0; numUnit < this.units.size(); numUnit++){
				int line = this.unitsPos.get(numUnit).getX();
				int col = this.unitsPos.get(numUnit).getY();
				switch (this.units.get(numUnit).getType()){
				case "FLY":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/fly/fly.png"));
					break;
				case "GUARD":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/guardian/guardian.png"));
					break;
				case "SNA":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/snake/snake.png"));
					break;
				case "QUEEN":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/queen/queen.png"));
					break;
				case "SCAR":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/scarab/scarab.png"));
					break;
				case "SCOUT":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/scout/scout.png"));
					break;
				case "SHOOT":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/shooter/shooter.png"));
					break;
				case "WARR":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/warrior/warrior.png"));
					break;
				case "WORK":
					wind.getLabelTab(line, col).getJlentity().setIcon(new ImageIcon("./img/mobs/worker/worker.png"));
					break;
				default:
				}
			}
		}
		else if (this.building != null){
			switch (this.building.getType()){
			case "AHILL":
				wind.getLabelTab(this.buildingPos.getX(), this.buildingPos.getY()).getJlentity().setIcon(new ImageIcon("./img/buildings/ANTHILL_BUILDING.png"));
				break;
			case "HOUSE":
				wind.getLabelTab(this.buildingPos.getX(), this.buildingPos.getY()).getJlentity().setIcon(new ImageIcon("./img/buildings/HOUSE_BUILDING.png"));
				break;
			case "POSTGUARD":
				wind.getLabelTab(this.buildingPos.getX(), this.buildingPos.getY()).getJlentity().setIcon(new ImageIcon("./img/buildings/POSTGUARD_BUILDING.png"));
				break;
			default:
			}
		}
		wind.getDisp().getJpanelLeft().setHp(0, 0);
		wind.getDisp().getJpanelLeft().setArmor(0);
	}
	
	/**
	 * Allows the player to move any of his unit.
	 */
	public void moveUnit(LabelCustom label) {
			// checks if the unit is owned by the player (team 1)
		if (this.wind.getLabelTab(this.unitsPos.get(0).getX(), this.unitsPos.get(0).getY()).getLabEntity().getTeam()==1){
			int line=0;
			int col=0;
			for (int numLabel = 0 ; numLabel < Map.NBCOLUMN*Map.NBLINE ; numLabel++){
				if (label==wind.getLabelTab(numLabel/Map.NBLINE, numLabel%Map.NBCOLUMN)){
					line = numLabel/Map.NBLINE;
					col = numLabel%Map.NBCOLUMN;
				}
			}
			Position destPos = new Position(line, col);
				// for every selected unit
			for (int numUnit = 0 ; numUnit < this.units.size() ; numUnit++) {
				
				InterfaceMap map = wind.getDisp().getGame().getMap();
				
				if (checkMoveSpeed(this.units.get(numUnit), this.unitsPos.get(numUnit), destPos)){
				
						//if there is no water/tree on the destination position and if there is no entity
					if (!(this.units.get(numUnit).moveAvailable(destPos, map))){
						Position newPos=null;
						int numPos = 0;
						newPos = getNewPosition(destPos, numPos, map);
						numPos++;
						while (numPos < 24 && !(this.units.get(numUnit).moveAvailable(newPos, map))){
							newPos = getNewPosition(destPos, numPos, map);
							numPos++;
						}
						if (this.units.get(numUnit).moveAvailable(newPos, map)){
							this.units.get(numUnit).moveUnit(newPos, this.unitsPos.get(numUnit), map, wind);
							clickState = 3;
						}
					}
					else{
						this.units.get(numUnit).moveUnit(destPos, this.unitsPos.get(numUnit), map, wind);
						clickState = 3;
					}
				}
			}
		}
	}
	
	/**
	 * checks the unit's movement speed, the unit position and the destination's position
	 * returns true if the move should be possible ; false otherwise
	 * @param unit
	 * @return
	 */
	private boolean checkMoveSpeed(Unit unit, Position posUnit, Position posDest) {
		if (Math.abs(posDest.getX()-posUnit.getX()) + Math.abs(posDest.getY()-posUnit.getY()) <= unit.getDeplacements())
			return true;
		return false;
	}

	/**
	 * Allow the player to select one building
	 * @param building
	 * @param label 
	 */
	@Override
	public void selectBuilding(LabelCustom label, MouseEvent e) {
		this.event = e;
		this.building = (Building) label.getLabEntity();
		int line=0;
		int col=0;
		for (int numLine = 0 ; numLine < Map.NBLINE ; numLine++){
			for (int numCol = 0 ; numCol < Map.NBCOLUMN ; numCol++){
				if (label == wind.getLabelTab(numLine, numCol)){
					line = numLine;
					col = numCol;
				}
			}
		}
		this.buildingPos = new Position(line, col);
		addPictureSelection();
	}
	
	/**
	 * Allows the player to create a building.
	 */
	public void createBuilding(String build) {		
		Building myBuild;
		int buildingCost=0;
		switch (build){
		case "AHILL":
			myBuild = new AntHill();
			buildingCost = 150;
			break;
		case "HOUSE":
			myBuild = new House();
			buildingCost = 120;
			break;
		case "POSTG":
			myBuild = new PostGuard();
			buildingCost = 110;
			break;
		default:
			myBuild = null;
		}
		if (buildingCost <= wind.getDisp().getJpanelLeft().getDirtValue()) {
			this.map.getCell(this.creatingPos).setEntity(myBuild);
			this.lab.addEntityMap(myBuild);
			wind.getDisp().getJpanelLeft().removeDirtValue(buildingCost);
		}
		
	}
	
	/**
	 * Used when the user is clicking on a cell.
	 * its main use is to move units
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		this.wind = (Window) e.getComponent().getParent().getParent().getParent().getParent().getParent().getParent();
		this.map = wind.getDisp().getGame().getMap();
		
		LabelCustom label = (LabelCustom) e.getComponent();
		
		if (label.getLabEntity() == null && e.getButton() != 3 && e.getButton() != 2){
			if (this.units != null && this.units.size() == 1 && this.units.get(0).getType() == "WORK"){
				label.requestFocusInWindow();
				// gets focus on label (used for next keylistener)
				reinitializeSelection();
				this.lab = label;
				for (int numLine = 0 ; numLine < Map.NBLINE ; numLine++){
					for (int numCol = 0 ; numCol < Map.NBCOLUMN ; numCol++){
						if (wind.getLabelTab(numLine, numCol) == label){
							this.creatingPos = new Position (numLine, numCol);
							return;
						}
					}
				}
			}
			
				// looses all the selected entities and then select the cell
			reinitializeSelection();
			return;
		}
			// different action depending on which mouse button was pressed
		switch (e.getButton()){
		case 3:		// move - attack         RIGHT CLICK
			if (clickState < 2 || this.units == null || this.units.get(0).getTeam() != 1){
				// no ally unit selected (=> unselect everything)
				this.reinitializeSelection();
				break;
			}
			
			this.moveUnit(label);
			clickState = 3;
			break;
			
		case 1:		// select				LEFT CLICK
			switch (clickState){
			case 0:
				if (label.getLabEntity().getMaxHealthPoints() > 40) { // building
					this.reinitializeSelection();
					selectBuilding(label, e);
					break;
				}
							// unit
				this.lab = (LabelCustom) e.getComponent();
				clickState=1;
				break;
			case 1:
				this.units = new LinkedList<Unit>();
				this.unitsPos = new LinkedList<Position>();
				this.selectUnits(this.lab, label, e);
				clickState=2;
				break;
			case 2: default: 	// looses all the selected units
				this.reinitializeSelection();
				break;
			}
			break;
			
		case 2:		// 	gather dirt			MIDDLE CLICK
			if (clickState >= 2 && this.units.size()==1 && lab.getLabEntity().getType()=="WORK") {
				gatherDirt();
				break;
			}
			this.reinitializeSelection();
			break;
		default:	// nothing happening
		}
		
	}

	/**
	 * reset all the attributes to null,
	 * except clickState wich is taking the value 0 (=nothing selected)
	 */
	public void reinitializeSelection(){
		if (this.event != null && clickState != 3)
			addPictureUnselection();
		this.units = null;
		this.unitsPos = null;
		this.building = null;
		this.buildingPos = null;
		this.creatingPos = null;
		this.lab = null;
		this.clickState = 0;
		keyState = 0;
		this.event = null;
	}
	
	/**
	 * the worker gathers food (by checking if there is any one cell everywhere around him
	 */
	private void gatherDirt() {
		Position newPos;
		for (int numPos = 0 ; numPos < 8 ; numPos++){
			newPos = getNewPosition(this.unitsPos.get(0), numPos, map);
			if (map.getCell(newPos).getCellState() == CellState.GRASS_SQUARE && map.getCell(newPos).getEntity() == null 
					&& map.getCell(newPos).getRessource().getDirtQuantity() != 0) {
				wind.getDisp().getJpanelLeft().addDirtValue(map.getCell(newPos).getRessource().getDirtQuantity());
				map.getCell(newPos).getRessource().setDirtQuantity(0);
				numPos = 7;		// same as a break here
			}
		}
		this.reinitializeSelection();
		
	}
	
	/**
	 * returns a new position within 2cells around the initial position
	 * @param pos
	 * @param numPos
	 * @param map
	 * @return
	 */
	public Position getNewPosition(Position pos, int numPos, InterfaceMap map){
		Position newPos = pos;
		switch (numPos){
		case 0:
			if (!(map.notOutOfTheMap(new Position(pos.getX()-1, pos.getY()-1)))){
				newPos = new Position(pos.getX()-1, pos.getY()-1);
			}
		case 1:
			if (!(map.notOutOfTheMap(new Position(pos.getX()-1, pos.getY())))){
				newPos = new Position(pos.getX()-1, pos.getY());
			}
		case 2:
			if (!(map.notOutOfTheMap(new Position(pos.getX()-1, pos.getY()+1)))){
				newPos = new Position(pos.getX()-1, pos.getY()+1);
			}
		case 3:
			if (!(map.notOutOfTheMap(new Position(pos.getX(), pos.getY()+1)))){
				newPos = new Position(pos.getX(), pos.getY()+1);
			}
		case 4:
			if (!(map.notOutOfTheMap(new Position(pos.getX()+1, pos.getY()+1)))){
				newPos = new Position(pos.getX()+1, pos.getY()+1);
			}
		case 5:
			if (!(map.notOutOfTheMap(new Position(pos.getX()+1, pos.getY())))){
				newPos = new Position(pos.getX()+1, pos.getY());
			}
		case 6:
			if (!(map.notOutOfTheMap(new Position(pos.getX()+1, pos.getY()-1)))){
				newPos = new Position(pos.getX()+1, pos.getY()-1);
			}
		case 7:
			if (!(map.notOutOfTheMap(new Position(pos.getX(), pos.getY()-1)))){
				newPos = new Position(pos.getX(), pos.getY()-1);
			}
		case 8:
			if (!(map.notOutOfTheMap(new Position(pos.getX()-2, pos.getY()-1)))){
				newPos = new Position(pos.getX()-2, pos.getY()-1);
			}
		case 9:
			if (!(map.notOutOfTheMap(new Position(pos.getX()-2, pos.getY())))){
				newPos = new Position(pos.getX()-2, pos.getY());
			}
		case 10:
			if (!(map.notOutOfTheMap(new Position(pos.getX()-2, pos.getY()+1)))){
				newPos = new Position(pos.getX()-2, pos.getY()+1);
			}
		case 11:
			if (!(map.notOutOfTheMap(new Position(pos.getX()-2, pos.getY()+2)))){
				newPos = new Position(pos.getX()-2, pos.getY()+2);
			}
		case 12:
			if (!(map.notOutOfTheMap(new Position(pos.getX()-1, pos.getY()+2)))){
				newPos = new Position(pos.getX()-1, pos.getY()+2);
			}
		case 13:
			if (!(map.notOutOfTheMap(new Position(pos.getX(), pos.getY()+2)))){
				newPos = new Position(pos.getX(), pos.getY()+2);
			}
		case 14:
			if (!(map.notOutOfTheMap(new Position(pos.getX()+1, pos.getY()+2)))){
				newPos = new Position(pos.getX()+1, pos.getY()+2);
			}
		case 15:
			if (!(map.notOutOfTheMap(new Position(pos.getX()+2, pos.getY()+2)))){
				newPos = new Position(pos.getX()+2, pos.getY()+2);
			}
		case 16:
			if (!(map.notOutOfTheMap(new Position(pos.getX()+2, pos.getY()+1)))){
				newPos = new Position(pos.getX()+2, pos.getY()+1);
			}
		case 17:
			if (!(map.notOutOfTheMap(new Position(pos.getX()+2, pos.getY())))){
				newPos = new Position(pos.getX()+2, pos.getY());
			}
		case 18:
			if (!(map.notOutOfTheMap(new Position(pos.getX()+2, pos.getY()-1)))){
				newPos = new Position(pos.getX()+2, pos.getY()-1);
			}
		case 19:
			if (!(map.notOutOfTheMap(new Position(pos.getX()+2, pos.getY()-2)))){
				newPos = new Position(pos.getX()+2, pos.getY()-2);
			}
		case 20:
			if (!(map.notOutOfTheMap(new Position(pos.getX()+1, pos.getY()-2)))){
				newPos = new Position(pos.getX()+1, pos.getY()-2);
			}
		case 21:
			if (!(map.notOutOfTheMap(new Position(pos.getX(), pos.getY()-2)))){
				newPos = new Position(pos.getX(), pos.getY()-2);
			}
		case 22:
			if (!(map.notOutOfTheMap(new Position(pos.getX()-1, pos.getY()-2)))){
				newPos = new Position(pos.getX()-1, pos.getY()-2);
			}
		case 23:
			if (!(map.notOutOfTheMap(new Position(pos.getX()-2, pos.getY()-2)))){
				newPos = new Position(pos.getX()-2, pos.getY()-2);
			}
		}
		return newPos;
	}
	
	// these following listeners probably won't be used
	@Override
	public void mouseEntered(MouseEvent e) {
		// Auto-generated method stub
				
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Auto-generated method stub

	}
	/**
	 * used when entering a cell
	 * its main use is to select units/building with their current position
	 * @param e
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent ev) {
			// first step => open a 'virtual' menu to create a new building
		if (keyState==0 && (ev.getKeyCode() == 66 || ev.getKeyCode() == 98)) { // if user pressed 'B' or 'b'
			keyState=1;
		}
		else { // second step => choose the building to build by pressing its first letter
			if (keyState==1 && (ev.getKeyCode() == 65 || ev.getKeyCode() == 97)) { // if user pressed 'A' or 'a'
				keyState=0;
				if (this.lab != null && lab.getLabEntity() == null)
					createBuilding("AHILL");
			} else if (keyState==1 && (ev.getKeyCode() == 72 || ev.getKeyCode() == 104)) { // if user pressed 'H' or 'h'
				keyState=0;
				if (this.lab != null && lab.getLabEntity() == null)
					createBuilding("HOUSE");
			} else if (keyState==1 && (ev.getKeyCode() == 80 || ev.getKeyCode() == 112)) { // if user pressed 'P' or 'p'
				keyState=0;
				if (this.lab != null && lab.getLabEntity() == null)
					createBuilding("POSTG");
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// Auto-generated method stub

	}
	
	/**
	 * used when a key is typed
	 * its only purpose will be to build a new building
	 */
	@Override
	public void keyTyped(KeyEvent ev) {
		// Auto-generated method stub

	}

}
