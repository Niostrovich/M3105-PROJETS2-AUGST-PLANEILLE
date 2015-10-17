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
	private JSplitPane split1;
	private JSplitPane split2;

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
		this.split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		init();
	}

	public void init() {
		this.setTitle("Age Of AntHill");
		this.setSize(300, 450);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		pan1.add(buttonNewGame);
		pan2.add(buttonLoadGame);
		pan3.add(buttonClose);
		split1.add(pan1);
		split1.add(pan2);
		split2.add(split1);
		split2.add(pan3);
		split1.setDividerLocation(150);
		split1.setDividerSize(0);
		split1.setEnabled(true);
		split2.setDividerLocation(300);
		split2.setDividerSize(0);
		split2.setEnabled(true);

		this.setContentPane(split2);

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