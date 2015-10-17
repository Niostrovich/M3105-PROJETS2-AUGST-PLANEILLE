package javaproject_ageOfAntHill;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javaproject_ageOfAntHill.map.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * create a window, with 3 choices (new game, load game, close)
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 */
@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener {
	private JButton buttonNewGame;
	private JButton buttonLoadGame;
	private JButton buttonClose;
	private Displaying disp;
	private JSplitPane splitVertical1;
	private JSplitPane splitVertical2;

	public Menu(Displaying disp) {
		this.disp = disp;
		buttonNewGame = new JButton("", new ImageIcon(
				"./img/overlay/BUTTON-NEWGAME.png"));
		buttonNewGame.setBorder(null);
		buttonLoadGame = new JButton("", new ImageIcon(
				"./img/overlay/BUTTON-LOADGAME.png"));
		buttonLoadGame.setBorder(null);
		buttonClose = new JButton("", new ImageIcon(
				"./img/overlay/BUTTON-CLOSE.png"));
		buttonClose.setBorder(null);
		this.splitVertical1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.splitVertical2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		init();
	}

	public void init() {
		this.setTitle("Age Of AntHill");
		this.setSize(300, 450);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		JPanel panNewButton = new JPanel();
		JPanel panLoadGame = new JPanel();
		JPanel panClose = new JPanel();
		
		panNewButton.add(buttonNewGame);
		panLoadGame.add(buttonLoadGame);
		panClose.add(buttonClose);
		
		splitVertical1.add(panNewButton);
		splitVertical1.add(panLoadGame);
		splitVertical2.add(splitVertical1);
		splitVertical2.add(panClose);
		
		splitVertical1.setDividerLocation(150);
		splitVertical1.setDividerSize(0);
		splitVertical1.setEnabled(true);
		splitVertical2.setDividerLocation(300);
		splitVertical2.setDividerSize(0);
		splitVertical2.setEnabled(true);

		this.setContentPane(splitVertical2);

		buttonNewGame.addActionListener(this);
		buttonLoadGame.addActionListener(this);
		buttonClose.addActionListener(this);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonClose) {
			this.disp.getFrame().dispose();
			this.dispose();
		} else if (e.getSource() == buttonNewGame) {
			this.disp.getFrame().setVisible(true);
			this.disp.startNewGame();
			this.dispose();
		} else if (e.getSource() == buttonLoadGame) {

			this.dispose();
		}
	}

}