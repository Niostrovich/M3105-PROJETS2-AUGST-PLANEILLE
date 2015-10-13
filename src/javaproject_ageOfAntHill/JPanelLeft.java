package javaproject_ageOfAntHill;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javaproject_ageOfAntHill.entity.Entity;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

@SuppressWarnings("serial")
public class JPanelLeft extends JPanel {
	
	/**
	 * Few JLabels contain all JLabels + the JButton
	 */
	private JLabel ressources;
	private JLabel food;
	private JLabel foodValue;
	private JLabel earth;
	private JLabel dirtValue;
	/**
	 * Few JLabel which contain the Selected unit + his values
	 */
	private JLabel selection;
	private JLabel selectionType;
	private JLabel stats;
	private JLabel hpUnit;
	private JLabel hpUnitValue;
	private JLabel currentArmor;
	private JLabel currentArmorValue;
	/**
	 * The JLabel used for the Overlay Background
	 */
	private JLabel overlay;
	/**
	 * Few JButton contain all building options
	 */
	private JButton building;
	private JButton anthill;
	private JButton house;
	private JButton outpost;
	
	/**
	 * Set the type of the food and the dirt values and unit informations
	 */
	private int foodValueInt;
	private int dirtValueInt;
	private int hpUnitValueInt;
	private int hpMaxUnitValueInt;
	private int currentArmorValueInt;
	/**
	 * The constructor of the JPanelLeft which contain all statistics and information about units etc...
	 * @param interfHM
	 */
	public JPanelLeft(InterfaceHM interfHM){
		
		setLayout(new OverlayLayout(this));
		/**
		 * Create the overlay for the JPanelLeft
		 */
		overlay = new JLabel(new ImageIcon("./img/overlay/LEFTPANEL_OVERLAY.png"));
		/**
		 * Define the current ressources of the player
		 */
		ressources = new JLabel("<html>Ressources :<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>", JLabel.CENTER);
		ressources.setForeground(Color.white);
		ressources.setFont(new Font("Sherif", Font.ITALIC, 20));
		/**
		 * Define the sample text for the food of the player
		 */
		food = new JLabel("<html>Food :<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>", new ImageIcon("./img/miscs/FOOD.png"), JLabel.CENTER);
		food.setForeground(Color.white);
		food.setFont(new Font("Sherif", Font.ITALIC, 15));
		/**
		 * Define the current FoodValue of the player
		 */
		foodValueInt = 800;
		foodValue = new JLabel("<html>" + foodValueInt + "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>", JLabel.CENTER);
		foodValue.setForeground(Color.white);
		foodValue.setFont(new Font("Sherif", Font.ITALIC, 15));
		/**
		 * Define the sample text for the dirt of the player
		 */
		earth = new JLabel("<html>Dirt :<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>", JLabel.CENTER);
		earth.setForeground(Color.white);
		earth.setFont(new Font("Sherif", Font.ITALIC, 15));
		/**
		 * Define the current dirtValue of the player
		 */
		dirtValueInt = 400;
		dirtValue = new JLabel("<html>" + dirtValueInt + "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>", JLabel.CENTER);
		dirtValue.setForeground(Color.white);
		dirtValue.setFont(new Font("Sherif", Font.ITALIC, 15));
		
		
		
		/**
		 * Define the JButton to build a new building
		 */
		building = new JButton(new ImageIcon("./img/overlay/BUILDING_ICON.png"));
		building.addActionListener((ActionListener) interfHM);
		building.setBorder(null);
		/**
		 * Set a JButton to create a new Building : House
		 */
		house = new JButton(new ImageIcon("./img/overlay/HOUSE_BUTTON.png"));
		house.addActionListener((ActionListener) interfHM);
		house.setBorder(null);
		/**
		 * Set a JButton to create a new Building : AntHill
		 */
		anthill = new JButton(new ImageIcon("./img/overlay/ANTHILL_BUTTON.png"));
		anthill.addActionListener((ActionListener) interfHM);
		anthill.setBorder(null);
		/**
		 * Set a JButton to create a new Building : Outpose
		 */
		outpost = new JButton(new ImageIcon("./img/overlay/OUTPOST_BUTTON.png"));
		outpost.addActionListener((ActionListener) interfHM);
		outpost.setBorder(null);
		

		
		/**
		 * Define the current hp of the selected Unit (not working for a multiple selection)
		 */
		hpUnit = new JLabel("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>HP :", JLabel.CENTER);
		hpUnit.setForeground(Color.white);
		hpUnit.setFont(new Font("Sherif", Font.ITALIC, 15));
		/**
		 * Define the current hpUnitValue of the Selected Unit
		 */
		hpUnitValue = new JLabel("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>" + hpUnitValueInt + "/" + hpMaxUnitValueInt, JLabel.CENTER);
		hpUnitValue.setForeground(Color.white);
		hpUnitValue.setFont(new Font("Sherif", Font.ITALIC, 15));
		/**
		 * Define the current armor of the selected Unit (not working for a multiple selection)
		 */
		currentArmor = new JLabel("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>" + "ARMOR :", JLabel.CENTER);
		currentArmor.setForeground(Color.white);
		currentArmor.setFont(new Font("Sherif", Font.ITALIC, 15));
		/**
		 * Define the current currentArmorValue of the Selected Unit
		 */
		currentArmorValue = new JLabel("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>" + currentArmorValueInt, JLabel.CENTER);
		currentArmorValue.setForeground(Color.white);
		currentArmorValue.setFont(new Font("Sherif", Font.ITALIC, 15));
		/**
		 * Define the current statistics of the player
		 */
		stats = new JLabel("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Statistics :", JLabel.CENTER);
		stats.setForeground(Color.white);
		stats.setFont(new Font("Sherif", Font.ITALIC, 20));
		/**
		 * the default Picture Displayed when the game start
		 * And selectionType to change the name
		 */
		selection = new JLabel(new ImageIcon("./img/mobs/worker/workerDisplay.png"), JLabel.CENTER);
		selectionType = new JLabel("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>" + selectionType + "", JLabel.CENTER);
		selectionType.setForeground(Color.white);
		selectionType.setFont(new Font("Sherif", Font.BOLD, 25));
		
		/**
		 * Those add the different JLabel / JButton to the layout
		 */
		add(ressources, 0);
		add(food, 1);
		add(foodValue, 2);
		add(earth, 3);
		add(dirtValue, 4);
		add(stats, 5);
		add(hpUnit, 6);
		add(hpUnitValue, 7);
		add(currentArmor, 8);
		add(currentArmorValue, 9);
		add(selectionType, 10);
		add(selection, 11);
		add(building, 12);
		//add(house, 13);
		//add(anthill, 14);
		//add(outpost, 15);
		add(overlay, 13);
	}
	/**
	 * This method get the Ressources (food & dirt)
	 * @return
	 */
	public JLabel getRessources(){
		return ressources;
	}
	/**
	 * This method get the background Picture
	 * @return overlay
	 */
	public JLabel getImage(){
		return overlay;
	}
	/**
	 * This method allows you to set the Maximum HP and the current HP of the Entity
	 * @param hp, maxHp
	 */
	public void setHp(int hp, int maxHp){
		this.hpUnitValueInt = hp;
		this.hpMaxUnitValueInt = maxHp;
	}
	
	/**
	 * This method allows you to set Armor of the Entity
	 * @param armor
	 */
	public void setArmor(int armor){
		this.currentArmorValueInt = armor;
	}
	
	/**
	 * Add food in the JPanelLeft
	 * @param foodValue
	 */
	public void addFoodValue(int foodValue){
		this.foodValueInt += foodValue;
		this.foodValue.setText("<html>" + this.foodValueInt + "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");
	}
	/**
	 * Remove food in the JPanelLeft
	 * @param foodValue
	 */
	public void removeFoodValue(int foodValue){
		this.foodValueInt -= foodValue;
		this.foodValue.setText("<html>" + this.foodValueInt + "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");
	}
	/**
	 * Add dirt in the JPanelLeft
	 * @param dirtValue
	 */
	public void addDirtValue(int dirtValue){
		this.dirtValueInt += dirtValue;
		this.dirtValue.setText("<html>" + this.dirtValueInt + "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");
	}
	/**
	 * Remove dirt in the JPanelLeft
	 * @param dirtValue
	 */
	public void removeDirtValue(int dirtValue){
		this.dirtValueInt -= dirtValue;
		this.dirtValue.setText("<html>" + this.dirtValueInt + "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");
	}
	/**
	 * returns the current amount of Dirt
	 * @return
	 */
	public int getDirtValue(){
		return this.dirtValueInt;
	}
	/**
	 * returns the current amount of food
	 * @return
	 */
	public int getFoodValue(){
		return this.foodValueInt;
	}
	
	
	/**
	 * change the state of the Displayed picture (Basic : Worker, changed with Fly, Scarab, Guardian, Shooter etc...) 
	 * @param ent
	 */
	public void selectionEntity(Entity ent){
		switch(ent.getType()){
		case "FLY":
			selection.setIcon(new ImageIcon("./img/mobs/fly/flyDisplay.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Fly");
			break;
		case "GUARD":
			selection.setIcon(new ImageIcon("./img/mobs/guardian/guardianDisplay.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Guardian");
			break;
		case "SNA":
			selection.setIcon(new ImageIcon("./img/mobs/snake/snakeDisplay.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Snake");
			break;
		case "QUEEN":
			selection.setIcon(new ImageIcon("./img/mobs/queen/queenDisplay.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Queen");
			break;
		case "SCAR":
			selection.setIcon(new ImageIcon("./img/mobs/scarab/scarabDisplay.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Scarab");
			break;
		case "SCOUT":
			selection.setIcon(new ImageIcon("./img/mobs/scout/scoutDisplay.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Scout");
			break;
		case "SHOOT":
			selection.setIcon(new ImageIcon("./img/mobs/shooter/shooterDisplay.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Shooter");
			break;
		case "WARR":
			selection.setIcon(new ImageIcon("./img/mobs/warrior/warriorDisplay.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Warrior");
			break;
		case "WORK":
			selection.setIcon(new ImageIcon("./img/mobs/worker/workerDisplay.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Worker");
			break;
		case "AHILL":
			selection.setIcon(new ImageIcon("./img/buildings/ANTHILL_BUILDING.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Anthill");
			break;
		case "HOUSE":
			selection.setIcon(new ImageIcon("./img/buildings/HOUSE_BUILDING.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>House");
			break;
		case "outpost":
			selection.setIcon(new ImageIcon("./img/buildings/OUTPOST_BUILDING.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>outpost");
			break;
		default:
		}
	}
	
	public void selectionEntity(int team){
		switch (team){
		case 1:
			selection.setIcon(new ImageIcon("./img/mobs/alliesDisplay.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Allies");
			break;
		case 2:
			selection.setIcon(new ImageIcon("./img/mobs/enemiesDisplay.png"));
			selectionType.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Enemies");
			break;
		}
	}
}
