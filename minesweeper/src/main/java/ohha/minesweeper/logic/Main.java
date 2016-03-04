package ohha.minesweeper.logic;

import ohha.minesweeper.ui.GUI;
import javax.swing.SwingUtilities;

/**
 * The Main class, basically just starts the show.
 */
public class Main {

    /**
     * The main method.
     * 
     * @param args parameter
     */
    public static void main(String[] args) {
        Runnable ui = new GUI();
        SwingUtilities.invokeLater(ui);
    }
}
