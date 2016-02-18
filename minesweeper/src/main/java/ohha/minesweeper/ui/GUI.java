package ohha.minesweeper.ui;

import java.awt.BorderLayout;
import ohha.minesweeper.logic.Game;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * The class is the main GUI class.
 */
public class GUI implements Runnable {

    private JFrame frame;
    private Game game;

    public GUI() {
        this.game = new Game(8, 10);
    }

    @Override
    public void run() {
        frame = new JFrame("Minesweeper");

        frame.setPreferredSize(new Dimension(600, 620));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    //bombs "left" (total - flagged) or progressbar :P
    private void createComponents(Container container) {
        
        container.setLayout(new BorderLayout());

        //a new window instead of JLabel?
        //"congrats - new game?" or "congrats - size?
        JLabel statusDisplay = new JLabel("Playing", SwingConstants.CENTER);
        JPanel grid = createGrid(statusDisplay);
        
        container.add(statusDisplay, BorderLayout.NORTH);
        container.add(grid, BorderLayout.CENTER);

    }

    //separate the grid entirely? newGame --> in Grid extends JPanel, alter it there..?
    //ugly if no remove component?
    //ToolTip first game? yeees, yees, quantity not quality
    //setdefaultbutton? rootpane??
    private JPanel createGrid(JLabel statusDisplay) {
        
        int size = this.game.getSizeOfGrid();
        JPanel grid = new JPanel(new GridLayout(size, size, 3, 3));
        
        //shared listener? button.name = place in grid? button - component
        
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                JButton button = new JButton();
                button.setActionCommand(String.valueOf(x) + ":" + String.valueOf(y));
                button.addActionListener(new TurnListener(game, button, statusDisplay, this));
                grid.add(button);
                
            }
        }        
       
        return grid;
    }
    
    //MenuBar instead? -> 'manually' (new game,rules,displaybombs?)
    //both? or button. or editablecombobox :P
    //JDialog, modal
    public void newGame(JLabel statusDisplay) {
        game = new Game(8,10);
        Container container = frame.getContentPane();
        container.remove(1);
        
        JPanel grid = this.createGrid(statusDisplay);
        
        container.add(grid, BorderLayout.CENTER);
    }

}
