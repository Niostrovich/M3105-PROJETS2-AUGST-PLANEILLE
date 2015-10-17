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

	private JLabel ressources;
	private JLabel food;
	private JLabel foodValue;
	private JLabel earth;
	private JLabel dirtValue;
	private JLabel selection;
	private JLabel selectionType;
	private JLabel stats;
	private JLabel hpUnit;
	private JLabel hpUnitValue;
	private JLabel currentArmor;
	private JLabel currentArmorValue;
	private JLabel overlay;
	private JButton building;
	private JButton anthill;
	private JButton house;
	private JButton outpost;
	private int foodValueInt;
	private int dirtValueInt;
	private int hpUnitValueInt;
	private int hpMaxUnitValueInt;
	private int currentArmorValueInt;

	public JPanelLeft(InterfaceHM interfHM) {

		setLayout(new OverlayLayout(this));
		overlay = new JLabel(new ImageIcon(
				"./img/overlay/LEFTPANEL_OVERLAY.png"));
		ressources = new JLabel(
				"<html>Ressources :<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>",
				JLabel.CENTER);
		ressources.setForeground(Color.white);
		ressources.setFont(new Font("Sherif", Font.ITALIC, 20));
		food = new JLabel(
				"<html>Food :<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>",
				new ImageIcon("./img/miscs/FOOD.png"), JLabel.CENTER);
		food.setForeground(Color.white);
		food.setFont(new Font("Sherif", Font.ITALIC, 15));
		foodValueInt = 800;
		foodValue = new JLabel(
				"<html>"
						+ foodValueInt
						+ "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>",
				JLabel.CENTER);
		foodValue.setForeground(Color.white);
		foodValue.setFont(new Font("Sherif", Font.ITALIC, 15));
		earth = new JLabel(
				"<html>Dirt :<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>",
				JLabel.CENTER);
		earth.setForeground(Color.white);
		earth.setFont(new Font("Sherif", Font.ITALIC, 15));
		dirtValueInt = 400;
		dirtValue = new JLabel(
				"<html>"
						+ dirtValueInt
						+ "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>",
				JLabel.CENTER);
		dirtValue.setForeground(Color.white);
		dirtValue.setFont(new Font("Sherif", Font.ITALIC, 15));

		building = new JButton(new ImageIcon("./img/overlay/BUILDING_ICON.png"));
		building.addActionListener((ActionListener) interfHM);
		building.setBorder(null);
		house = new JButton(new ImageIcon("./img/overlay/HOUSE_BUTTON.png"));
		house.addActionListener((ActionListener) interfHM);
		house.setBorder(null);
		anthill = new JButton(new ImageIcon("./img/overlay/ANTHILL_BUTTON.png"));
		anthill.addActionListener((ActionListener) interfHM);
		anthill.setBorder(null);
		outpost = new JButton(new ImageIcon("./img/overlay/OUTPOST_BUTTON.png"));
		outpost.addActionListener((ActionListener) interfHM);
		outpost.setBorder(null);
		hpUnit = new JLabel(
				"<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>HP :",
				JLabel.CENTER);
		hpUnit.setForeground(Color.white);
		hpUnit.setFont(new Font("Sherif", Font.ITALIC, 15));
		hpUnitValue = new JLabel(
				"<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>"
						+ hpUnitValueInt + "/" + hpMaxUnitValueInt,
				JLabel.CENTER);
		hpUnitValue.setForeground(Color.white);
		hpUnitValue.setFont(new Font("Sherif", Font.ITALIC, 15));
		currentArmor = new JLabel(
				"<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>"
						+ "ARMOR :", JLabel.CENTER);
		currentArmor.setForeground(Color.white);
		currentArmor.setFont(new Font("Sherif", Font.ITALIC, 15));
		currentArmorValue = new JLabel(
				"<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>"
						+ currentArmorValueInt, JLabel.CENTER);
		currentArmorValue.setForeground(Color.white);
		currentArmorValue.setFont(new Font("Sherif", Font.ITALIC, 15));
		stats = new JLabel(
				"<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Statistics :",
				JLabel.CENTER);
		stats.setForeground(Color.white);
		stats.setFont(new Font("Sherif", Font.ITALIC, 20));
		selection = new JLabel(new ImageIcon(
				"./img/mobs/worker/workerDisplay.png"), JLabel.CENTER);
		selectionType = new JLabel(
				"<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>"
						+ selectionType + "", JLabel.CENTER);
		selectionType.setForeground(Color.white);
		selectionType.setFont(new Font("Sherif", Font.BOLD, 25));
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
		add(overlay, 13);
	}

	public JLabel getRessources() {
		return ressources;
	}

	public JLabel getImage() {
		return overlay;
	}

	public void setHp(int hp, int maxHp) {
		this.hpUnitValueInt = hp;
		this.hpMaxUnitValueInt = maxHp;
	}

	public void setArmor(int armor) {
		this.currentArmorValueInt = armor;
	}

	public void addFoodValue(int foodValue) {
		this.foodValueInt += foodValue;
		this.foodValue
				.setText("<html>"
						+ this.foodValueInt
						+ "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");
	}

	public void removeFoodValue(int foodValue) {
		this.foodValueInt -= foodValue;
		this.foodValue
				.setText("<html>"
						+ this.foodValueInt
						+ "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");
	}

	public void addDirtValue(int dirtValue) {
		this.dirtValueInt += dirtValue;
		this.dirtValue
				.setText("<html>"
						+ this.dirtValueInt
						+ "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");
	}

	public void removeDirtValue(int dirtValue) {
		this.dirtValueInt -= dirtValue;
		this.dirtValue
				.setText("<html>"
						+ this.dirtValueInt
						+ "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");
	}

	public int getDirtValue() {
		return this.dirtValueInt;
	}

	public int getFoodValue() {
		return this.foodValueInt;
	}

	public void selectionEntity(Entity ent) {
		switch (ent.getType()) {
		case "FLY":
			selection.setIcon(new ImageIcon("./img/mobs/fly/flyDisplay.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Fly");
			break;
		case "GUARD":
			selection.setIcon(new ImageIcon(
					"./img/mobs/guardian/guardianDisplay.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Guardian");
			break;
		case "SNA":
			selection
					.setIcon(new ImageIcon("./img/mobs/snake/snakeDisplay.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Snake");
			break;
		case "QUEEN":
			selection
					.setIcon(new ImageIcon("./img/mobs/queen/queenDisplay.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Queen");
			break;
		case "SCAR":
			selection.setIcon(new ImageIcon(
					"./img/mobs/scarab/scarabDisplay.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Scarab");
			break;
		case "SCOUT":
			selection
					.setIcon(new ImageIcon("./img/mobs/scout/scoutDisplay.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Scout");
			break;
		case "SHOOT":
			selection.setIcon(new ImageIcon(
					"./img/mobs/shooter/shooterDisplay.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Shooter");
			break;
		case "WARR":
			selection.setIcon(new ImageIcon(
					"./img/mobs/warrior/warriorDisplay.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Warrior");
			break;
		case "WORK":
			selection.setIcon(new ImageIcon(
					"./img/mobs/worker/workerDisplay.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Worker");
			break;
		case "AHILL":
			selection.setIcon(new ImageIcon(
					"./img/buildings/ANTHILL_BUILDING.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Anthill");
			break;
		case "HOUSE":
			selection.setIcon(new ImageIcon(
					"./img/buildings/HOUSE_BUILDING.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>House");
			break;
		case "outpost":
			selection.setIcon(new ImageIcon(
					"./img/buildings/OUTPOST_BUILDING.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>outpost");
			break;
		default:
		}
	}

	public void selectionEntity(int team) {
		switch (team) {
		case 1:
			selection.setIcon(new ImageIcon("./img/mobs/alliesDisplay.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Allies");
			break;
		case 2:
			selection.setIcon(new ImageIcon("./img/mobs/enemiesDisplay.png"));
			selectionType
					.setText("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>Enemies");
			break;
		}
	}
}
