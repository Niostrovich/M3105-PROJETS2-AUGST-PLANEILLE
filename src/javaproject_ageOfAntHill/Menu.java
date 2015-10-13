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
 *         
 * @version 20150609
 *
 */
@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener {
	/**
	 * used to start a new game
	 */
	private JButton buttonNewGame;
	/**
	 * used to load a game
	 */
	private JButton buttonLoadGame;
	/**
	 * closes the game
	 */
	private JButton buttonClose;
	/**
	 * window of the game
	 */
	private Displaying disp;
	/**
	 * contains the button "New game" and the button "load game"
	 */
	private JSplitPane split1;
	/**
	 * contains the JsplitPane split1 and the button "close"
	 */
	private JSplitPane split2;
	
	/**
	 *builder of the menu display
	 * 
	 * @param disp
	 */
	public Menu(Displaying disp){
		this.disp = disp;
		buttonNewGame = new JButton("", new ImageIcon("./img/overlay/BUTTON-NEWGAME.png"));
		buttonNewGame.setBorder(null);
		buttonLoadGame = new JButton("",  new ImageIcon("./img/overlay/BUTTON-LOADGAME.png"));
		buttonLoadGame.setBorder(null);
		buttonClose = new JButton("",  new ImageIcon("./img/overlay/BUTTON-CLOSE.png"));
		buttonClose.setBorder(null);
		this.split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		init();
	}
	
	/**
	 * method to build the menu	
	 */
	public void init()
	{
	/**
	 * Set the basic of the "launcher" window
	 */
	this.setTitle("Age Of AntHill");	
	this.setSize(300, 450);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	/**
	 * Set the 3 different Panel to set the 3 JButtons
	 */
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel pan3 = new JPanel();
	/**
	 * Add JButtons to JPanel
	 */
	pan1.add(buttonNewGame);
	pan2.add(buttonLoadGame);
	pan3.add(buttonClose);
	/**
	 * split the different buttons
	 */
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
	
	/**
	 * add the 3 Action Listener to the JButtons
	 */
	buttonNewGame.addActionListener(this);
	buttonLoadGame.addActionListener(this);
	buttonClose.addActionListener(this);
	
	
	this.setVisible(true);
	}
	
	/**
	 * event on the button ( here we have 3 button)
	 * allow to do something on the click
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == buttonClose){
		this.disp.getFrame().dispose();
		this.dispose();	
	} else if(e.getSource() == buttonNewGame){
		this.disp.getFrame().setVisible(true);
		this.disp.startNewGame();
		this.dispose();
	} else if (e.getSource() == buttonLoadGame){
		
		this.dispose();
	}
	}
	
}


