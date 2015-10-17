package javaproject_ageOfAntHill;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javaproject_ageOfAntHill.map.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private LabelCustom[][] tab;
	private InterfaceHM interfHM;
	private Displaying disp;

	Window(Displaying disp, InterfaceHM interfHM) {
		this.disp = disp;
		this.tab = new LabelCustom[Map.NBLINE][Map.NBCOLUMN];
		this.interfHM = interfHM;
	}

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

	public void addCellTab(int numCell, LabelCustom[][] tabEntity,
			LabelCustom cell) {
		int col = numCell % Map.NBCOLUMN;
		int line = numCell / Map.NBLINE;
		tabEntity[line][col] = cell;
	}

	public LabelCustom getLabelTab(int line, int col) {
		return this.tab[line][col];
	}

	public Displaying getDisp() {
		return this.disp;
	}

}