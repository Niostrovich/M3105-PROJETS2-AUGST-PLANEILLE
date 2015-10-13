package javaproject_ageOfAntHill;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import javaproject_ageOfAntHill.entity.Entity;
import javaproject_ageOfAntHill.map.CellState;

/**
 * Used (temporarily) to customize the JButton Class. Then we can use customized
 * buttons.
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 *
 */
@SuppressWarnings("serial")
public class LabelCustom extends JPanel {

	private Entity entity;
	private JLabel jlground;
	private JLabel jlentity;

	/**
	 * @param nbLine
	 * @param nbCol
	 */
	public LabelCustom(int nbLine, int nbCol) {

		// sets grass as default picture
		setLayout(new OverlayLayout(this));
		jlground = new JLabel(new ImageIcon("./img/GRASS_SQUARE.png"));
		// jlguard = new JLabel(new
		// ImageIcon("./img/mobs/guardian/guardian-bd.png"));
		jlentity = new JLabel();
		add(jlentity, 0);
		jlground = new JLabel(new ImageIcon("./img/tiles/GRASS_SQUARE.png"));
		add(jlground, 1);
	}
	
	/**
	 * returns the label containing the entity's picture
	 * @return
	 */
	public JLabel getJlentity() {
		return jlentity;
	}
	
	public JLabel getJlground() {
		return jlground;
	}
	
	/**
	 * returns the Entity 
	 * @return
	 */
	public Entity getLabEntity(){
		return this.entity;
	}
	
	public void addEntityMap(Entity entity){
		this.entity=entity;
		switch (this.entity.getType()){
		case "FLY":
			jlentity.setIcon(new ImageIcon("./img/mobs/fly/fly.png"));
			break;
		case "GUARD":
			jlentity.setIcon(new ImageIcon("./img/mobs/guardian/guardian.png"));
			break;
		case "SNA":
			jlentity.setIcon(new ImageIcon("./img/mobs/snake/snake.png"));
			break;
		case "QUEEN":
			jlentity.setIcon(new ImageIcon("./img/mobs/queen/queen.png"));
			break;
		case "SCAR":
			jlentity.setIcon(new ImageIcon("./img/mobs/scarab/scarab.png"));
			break;
		case "SCOUT":
			jlentity.setIcon(new ImageIcon("./img/mobs/scout/scout.png"));
			break;
		case "SHOOT":
			jlentity.setIcon(new ImageIcon("./img/mobs/shooter/shooter.png"));
			break;
		case "WARR":
			jlentity.setIcon(new ImageIcon("./img/mobs/warrior/warrior.png"));
			break;
		case "WORK":
			jlentity.setIcon(new ImageIcon("./img/mobs/worker/worker.png"));
			break;
		case "AHILL":
			jlentity.setIcon(new ImageIcon("./img/buildings/ANTHILL_BUILDING.png"));
			break;
		case "HOUSE":
			jlentity.setIcon(new ImageIcon("./img/buildings/HOUSE_BUILDING.png"));
			break;
		case "POSTG":
			jlentity.setIcon(new ImageIcon("./img/buildings/OUTPOST_BUILDING.png"));
			break;
		default:
		}
	}
	
	public void rmvEntityMap(){
		this.entity=null;
		jlentity.setIcon(null);
	}
	
	public void switchGroundPicture(CellState color) {
		switch (color) {
		case SAND_SQUARE:
			jlground.setIcon(new ImageIcon("./img/tiles/SAND_SQUARE.png"));
			break;
		case WATER_SQUARE:
			jlground.setIcon(new ImageIcon("./img/tiles/WATER_SQUARE.png"));
			break;
		case TREE_SQUARE:
			jlground.setIcon(new ImageIcon("./img/tiles/TREE_SQUARE.png"));
			break;
		case GRASS_SQUARE:
		default:
			jlground.setIcon(new ImageIcon("./img/tiles/GRASS_SQUARE.png"));
			break;
		}
	}

	public void rmvGroundMap() {
		jlground.setIcon(null);
		jlground.setIcon(new ImageIcon("./img/tiles/GRASS_SQUARE.png"));
	}

}
