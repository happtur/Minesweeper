package ohha.minesweeper.ui;

import ohha.minesweeper.ui.dialog.GameChoicesDialog;
import java.awt.BorderLayout;
import ohha.minesweeper.logic.Game;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

/**
 * The class is the main GUI class.
 */
public class GUI implements Runnable {

    private JFrame frame;
    private Game game;

    @Override
    public void run() {
        frame = new JFrame("Minesweeper");

        frame.setPreferredSize(new Dimension(600, 620));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {

        game = new Game(8, 10);

        container.setLayout(new BorderLayout());

        DisplayPanel display = new DisplayPanel(game.amountOfBombs());
        
        ButtonGrid grid = new ButtonGrid(game.getSizeOfGrid());
        TurnListener listener = new TurnListener(game, grid, display, this);
        grid.addActionListenerToButtons(listener);
        grid.setToolTipTextForButtons("Left-click turns, right-click flags");

        //a button in "display" instead of menu?
        this.createMenu(display);
        container.add(display, BorderLayout.NORTH);
        container.add(grid, BorderLayout.CENTER);

    }
    
    private void createMenu(DisplayPanel display) {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        
        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        //newGameMenuItem.setAccelerator(KeyStroke.get ...);
        //create Action...? just listener
        menu.add(newGameMenuItem);
        
        JMenuItem gameRules = new JMenuItem("Instructions");
        //add icon
        //listener + rulethingy
        menu.add(gameRules);
        
        //display bombsLeft-checkbox?
        
        frame.setJMenuBar(menuBar);
    }

    /**
     * The method starts and displays a new game.
     * 
     * @param display the game's status display
     */
    public void newGame(DisplayPanel display) {

        this.createGame();

        Container container = frame.getContentPane();
        container.remove(1);

        ButtonGrid grid = new ButtonGrid(game.getSizeOfGrid());
        TurnListener listener = new TurnListener(game, grid, display, this);
        grid.addActionListenerToButtons(listener);

        container.add(grid, BorderLayout.CENTER);
        display.setBombs(game.amountOfBombs());
        
        frame.pack();
    }

    private void createGame() {

        GameChoicesDialog dialog = new GameChoicesDialog(frame);
        int size = dialog.getGridSize();
        int bombs = dialog.getBombAmount();
        
        this.game = new Game(size, bombs);
    }

    public JFrame getFrame() {
        return this.frame;
    }
    

}
