package javaproject_ageOfAntHill;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javaproject_ageOfAntHill.map.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	
	/**
	 * used to place units images (they're stored inside this grid of the game)
	 */
	private LabelCustom[][] tab;
	/**
	 * main interface of the game (events, etc...)
	 */
	private InterfaceHM interfHM;
	/**
	 * displaying this window
	 */
	private Displaying disp;
	
	/**
	 * Creation of the frame
	 */
	Window (Displaying disp, InterfaceHM interfHM){
		this.disp = disp;
		this.tab = new LabelCustom[Map.NBLINE][Map.NBCOLUMN];
		this.interfHM = interfHM;
	}
	
	/**
	 *  creation of the cells of the game grid
	 */
	public void addGameGrid(JPanel panGame) {
			for (int numCell = 0; numCell < Map.NBLINE * Map.NBCOLUMN; numCell++) {
				LabelCustom cell = new LabelCustom(Map.NBLINE, Map.NBCOLUMN);
				cell.addMouseListener((MouseListener) this.interfHM);
				cell.addKeyListener((KeyListener) this.interfHM);
				cell.setFocusable(true);
				panGame.add(cell);
				this.addCellTab(numCell, tab, cell);
				panGame.setComponentZOrder(cell, numCell);
			}
	}
	
	/**
	 * adds a cell (LabelCustom) in the grid game
	 * @param numCell
	 * @param tabEntity
	 * @param cell
	 */
	public void addCellTab(int numCell, LabelCustom[][] tabEntity, LabelCustom cell){
		int col=numCell%Map.NBCOLUMN;
		int line=numCell/Map.NBLINE;
		tabEntity[line][col]=cell;
	}
	
	/**
	 * returns the LabelCustom (cell) at the given line/column
	 * @param line
	 * @param col
	 * @return
	 */
	public LabelCustom getLabelTab(int line, int col){
		return this.tab[line][col];
	}
	
	/**
	 * returns the displaying window
	 * @return
	 */
	public Displaying getDisp(){
		return this.disp;
	}
	
}
