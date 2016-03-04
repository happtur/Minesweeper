package ohha.minesweeper.ui.frame;

import ohha.minesweeper.ui.frame.DisplayPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import ohha.minesweeper.ui.GUI;
import ohha.minesweeper.ui.grid.ButtonGrid;

/**
 * The class is the main frame of the GUI.
 */
public class MainFrame extends JFrame {

    /**
     * The constructor.
     *
     * @param display the DisplayPanel that's going to be a component in the
     * frame
     * @param grid the ButtonGrid that's going to be a component in the frame
     * @param gui the main ui object
     */
    public MainFrame(DisplayPanel display, ButtonGrid grid, GUI gui) {
        super("Minesweeper");
        this.setPreferredSize(new Dimension(600, 620));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = this.getContentPane();

        container.setLayout(new BorderLayout());

        container.add(display, BorderLayout.NORTH);
        container.add(grid, BorderLayout.CENTER);

        this.createMenu(display, gui);

        this.pack();
    }

    private void createMenu(DisplayPanel display, GUI gui) {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        //newGameMenuItem.setAccelerator(KeyStroke.get ...);
        newGameMenuItem.setActionCommand("new game");
        menu.add(newGameMenuItem);

        JMenuItem gameRules = new JMenuItem("Instructions");
        //add icon
        gameRules.setActionCommand("rules");
        menu.add(gameRules);

        ActionListener listener = new MenuActionListener(gui);
        newGameMenuItem.addActionListener(listener);
        gameRules.addActionListener(listener);

        this.setJMenuBar(menuBar);
    }

    /**
     * The method replaces the current ButtonGrid with the grid given as a
     * parameter.
     *
     * @param grid the new ButtonGrid
     */
    public void replaceButtonGrid(ButtonGrid grid) {
        Container container = this.getContentPane();
        container.remove(1);

        container.add(grid, BorderLayout.CENTER);

        this.pack();
    }

}
