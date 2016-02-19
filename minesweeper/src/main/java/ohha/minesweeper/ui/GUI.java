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
        JPanel grid = createGrid(display);
        
        container.add(display, BorderLayout.NORTH);
        container.add(grid, BorderLayout.CENTER);

    }

    //separate the grid entirely? newGame --> in Grid extends JPanel, alter it there..?
    //ugly if no remove component?
    //ToolTip first round? yeees, yees, quantity not quality
    //setdefaultbutton? rootpane??
    private JPanel createGrid(DisplayPanel display) {
        
        int size = this.game.getSizeOfGrid();
        JPanel grid = new JPanel(new GridLayout(size, size, 3, 3));
        
        //shared listener? button.name = place in grid? button - component
        
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                JButton button = new JButton();
                button.setActionCommand(String.valueOf(x) + ":" + String.valueOf(y));
                button.addActionListener(new TurnListener(game, button, display, this));
                grid.add(button);
                
            }
        }        
       
        return grid;
    }
    
    //MenuBar instead? -> 'manually' (new game,rules,displaybombs?)
    //both? or button. or editablecombobox :P
    //JDialog, modal
    //Action (how do they work), both in menu and listener
    public void newGame(DisplayPanel display) {
        
        this.createGame();
        
        Container container = frame.getContentPane();
        container.remove(1);
        
        display.setBombs(game.amountOfBombs());
        JPanel grid = this.createGrid(display);
        
        container.add(grid, BorderLayout.CENTER);
    }
    
    private void createGame() {
        
        //ask player: size? bombs?
        
        this.game = new Game(8, 10);
    }

}
