package ohha.minesweeper.ui;

import java.awt.BorderLayout;
import ohha.minesweeper.logic.Game;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

        this.createGame();

        container.setLayout(new BorderLayout());

        DisplayPanel display = new DisplayPanel(game.amountOfBombs());
        //JPanel grid = createGrid(display);
        GridPanel grid = new GridPanel(game.getSizeOfGrid());
        TurnListener listener = new TurnListener(game, grid, display, this);
        grid.addActionListenerToButtons(listener);

        container.add(display, BorderLayout.NORTH);
        container.add(grid, BorderLayout.CENTER);

    }

    //MenuBar instead? -> 'manually' (new game,rules,displaybombsleft?)
    //both? or button.
    //Action (how does it work), both in menu and listener?
    /**
     * The method starts and displays a new game.
     * 
     * @param display the game's status display
     */
    public void newGame(DisplayPanel display) {

        this.createGame();

        Container container = frame.getContentPane();
        container.remove(1);

        display.setBombs(game.amountOfBombs());
        GridPanel grid = new GridPanel(game.getSizeOfGrid());
        TurnListener listener = new TurnListener(game, grid, display, this);
        grid.addActionListenerToButtons(listener);

        container.add(grid, BorderLayout.CENTER);
    }

    private void createGame() {

        //ask player: size? bombs?
        //JDialog, modal. or editablecombobox :P
        this.game = new Game(8, 10);
    }

}
