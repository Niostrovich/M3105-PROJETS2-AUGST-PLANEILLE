package javaproject_ageOfAntHill;

import javaproject_ageOfAntHill.map.Map;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;

/**
 * Used to (temporarily) display the graphic interface.
 * 
 * @author Maxime Augst, Joris Chalumeau, Nicolas Logut, Mathieu Berthet, Adrian
 *         Amaglio, Adrien Arsac
 * @version 20150607
 */
public class Displaying implements Runnable, ActionListener {
	SaveManager saveManager;
	/**
	 * represents the 'current' game
	 * its value is null if there is no current game
	 */
	private Game game;
	/**
	 * Default value of the window's width.
	 */
	private final static int DEFAULT_WINDOW_WIDTH = 980;
	/**
	 * Default value of the window's height.
	 */
	private final static int DEFAULT_WINDOW_HEIGHT = 980;
	/**
	 * Window of the game.
	 */
	private Window window;

	/**
	 * Items in the JMenu bar.
	 */
	private JMenuItem itemAbout;
	private JMenuItem itemClose;
	private JMenuItem itemNewGame;
	private JMenuItem itemSaveGame;
	private JMenuItem itemLoadGame;

	/**
	 * Grid of the game.
	 */
	private JPanel gridOfTheGame;
	/**
	 * Panel that displays informations on the selected units.
	 */
	private JPanel ressourcesOfThePlayer;
	/**
	 * Part of the window with the game and the menu bar.
	 */
	private JSplitPane splitGame;
	/**
	 * Part of the window with the ressources of the player.
	 */
	private JSplitPane splitRessources;
	/**
	 * Menu bar of the window.
	 */
	private JMenuBar menuBar;

	/**
	 * Used to change the window's layout (especially the panel of the game).
	 */
	private JPanelLeft jpanelLeft;
	private JSplitPane splitWindow;
	private JPanel banner;
	/**
	 * interface etc...
	 */
	private InterfaceHM interfHM;

	public Displaying(InterfaceHM interfHM) {
		this.saveManager = new SaveManager();

		this.window = new Window(this, interfHM);
		this.interfHM = interfHM;
		this.splitGame = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.splitRessources = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		this.menuBar = new JMenuBar();
		this.jpanelLeft = new JPanelLeft(interfHM);

		this.window.setJMenuBar(this.menuBar);
		this.gridOfTheGame = new JPanel();
		this.ressourcesOfThePlayer = new JPanel();
		this.splitWindow = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.banner = new JPanel();
		this.initGraphInt();
	}

	@Override
	public void run() {
		// will be used later
	}

	/**
	 * The main frame of the game, contain the size and a bunch of parameters.
	 */
	private void initGraphInt() {
		this.window.setTitle("Age Of AntHill **ALPHA INDEV 0.0000001**");

		/**
		 * This is the minimum and maximum width and height of the window.
		 * 
		 **/

		this.window.setSize(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
		this.window.setMinimumSize(new Dimension(DEFAULT_WINDOW_WIDTH,
				DEFAULT_WINDOW_HEIGHT));
		this.window.setMaximumSize(new Dimension(DEFAULT_WINDOW_WIDTH,
				DEFAULT_WINDOW_HEIGHT));

		this.window.setLocationRelativeTo(null);
		this.window.setAlwaysOnTop(true);
		this.window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.window.setResizable(false);

		// creation of the MenuBar
		JMenu menu = new JMenu("Menu");
		this.itemAbout = new JMenuItem("About");
		this.itemClose = new JMenuItem("Close");

		menu.add(this.itemAbout);
		menu.add(this.itemClose);

		// add action listener
		this.itemAbout.addActionListener(this);
		this.itemClose.addActionListener(this);
		this.menuBar.add(menu);

		// creation of the game Menu
		JMenu game = new JMenu("Game");
		this.itemNewGame = new JMenuItem("New game");
		this.itemSaveGame = new JMenuItem("Save game");
		this.itemLoadGame = new JMenuItem("load a game");

		// add item on the bar menu
		game.add(this.itemNewGame);
		game.add(this.itemSaveGame);
		game.add(this.itemLoadGame);

		// add action listener on the items
		this.itemNewGame.addActionListener(this);
		this.itemSaveGame.addActionListener(this);
		this.itemLoadGame.addActionListener(this);

		// add a menu option
		this.menuBar.add(game);

		this.gridOfTheGame.setBounds(0, 0, DEFAULT_WINDOW_WIDTH,
				DEFAULT_WINDOW_HEIGHT);
		GridLayout gl = new GridLayout(Map.NBLINE, Map.NBCOLUMN);
		this.gridOfTheGame.setLayout(gl);

		this.window.addGameGrid(this.gridOfTheGame);

		// add on the JPanel ressourcesOfThePlayer the JPanel jpanelLeft
		ressourcesOfThePlayer.add(this.jpanelLeft);

		// add on the JSplitpane SplitGame,the gridOfTheGame( map)
		splitGame.add(this.gridOfTheGame);
		splitGame.setDividerLocation(900);
		splitGame.setDividerSize(0);

		// add on the JSplitpane splitRessource, the jpanelLeft
		splitRessources.add(this.jpanelLeft);
		splitRessources.setSize(100, DEFAULT_WINDOW_HEIGHT);
		splitRessources.setDividerLocation(100);
		splitRessources.setDividerSize(0);

		// creation label with an image(it's the banner on the top of the
		// window)
		JLabel JBanner = new JLabel();
		ImageIcon imgBanner = new ImageIcon("./img/overlay/BANNER_OVERLAY.png");
		JBanner.setSize(imgBanner.getIconWidth(), imgBanner.getIconHeight());
		JBanner.setIcon(imgBanner);
		banner.add(JBanner);

		splitWindow.setLayout(new BorderLayout());
		splitWindow.add(splitRessources, BorderLayout.WEST);
		splitWindow.add(splitGame, BorderLayout.CENTER);
		splitWindow.add(banner, BorderLayout.NORTH);
		splitWindow.setBorder(null);
		splitWindow.setDividerSize(0);
		splitWindow.setEnabled(false);

		// add in the JFrame "window", the splitWindow
		this.window.setContentPane(this.splitWindow);
		this.window.setVisible(false);

	}
	
	/**
	 * returns the GridOfTheGame panel
	 * @return
	 */
	public JPanel getGridOfTheGame() {
		return gridOfTheGame;
	}
	
	/**
	 * panel GridOfTheGame
	 * @param gridOfTheGame
	 */
	public void setGridOfTheGame(JPanel gridOfTheGame) {
		this.gridOfTheGame = gridOfTheGame;
	}
	
	/**
	 * when clicked on an item of the JMenuBar
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		JMenuItem selectedItem = (JMenuItem) event.getSource();

		String instructions = "Instructions :\n";
		instructions += "Double click to select one unit or one building\n";
		instructions += "Left click on a cell then click again on another cell\n";
		instructions += " to select all the units of the same team in a rectangle area\n";
		instructions += "Right click to move the selected units to the targetted area\n";
		instructions += "note : some units might not be able to move if there isn't enough room\n\n";
		instructions += "You can use your worker ants in order to gather dirt (by digging in an empty area with grass)\n";
		instructions += "In this case you have to press middle click on a cell while a worker is selected in order to gather dirt\n";
		instructions += "You get food by killing an enemy unit\n";
		instructions += "Your initial amount of food is 800 and your initial amount of dirt is 400\n";
		instructions += "\n\nTo create a building, you first need to select a worker and then press b\n";
		instructions += "Then you need to clic on a near cell\n";
		instructions += "Finally you have to choose a building : a=AntHill ; h=House ; p=PostGame";

		if (selectedItem == this.itemAbout) {
			JOptionPane.showMessageDialog(this.window, instructions, "About",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (selectedItem == this.itemNewGame) {
			startNewGame();
		} else if (selectedItem == this.itemSaveGame) {
			this.saveManager.addSave(this.game.getMap().getGrid());
		} else if (selectedItem == this.itemLoadGame) {
			JOptionPane.showMessageDialog(this.window,
					this.saveManager.listSaves(), "Charger Partie",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (selectedItem == this.itemClose) {
			this.window.dispose();
		}
	}
	
	/**
	 * returns the window of this game
	 * @return
	 */
	public Window getFrame() {
		return this.window;
	}
	
	/**
	 * starts a new game
	 */
	public void startNewGame(){
		// reinitialization of the current game
		if (this.game != null){
			this.game.reinitMap();
			this.game = null;
				// to resset all the labels' pictures one by one
			for (int numLine =0 ; numLine < Map.NBLINE; numLine++){
				for (int numCol =0 ; numCol < Map.NBCOLUMN ; numCol++){
					this.window.getLabelTab(numLine, numCol).rmvEntityMap();
					this.window.getLabelTab(numLine, numCol).rmvGroundMap();
				}
			}
		}
		
		// creating the new game
		this.game = new Game(interfHM);
		this.game.createGame(this);
	}
	
	/**
	 * returns the jpanel jpanelLeft
	 * @return
	 */
	public JPanelLeft getJpanelLeft(){
		return this.jpanelLeft;
	}
	
	/**
	 * returns the current game
	 * @return
	 */
	public Game getGame(){
		return this.game;
	}

}
