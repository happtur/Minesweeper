
package ohha.minesweeper.logic;

import ohha.minesweeper.ui.GUI;
import ohha.minesweeper.ui.TextUI;
import javax.swing.SwingUtilities;

/**
 * The Main class, basically just starts the show.
 */

public class Main {
    
    public static void main(String[] args) {
        Runnable ui = new GUI();
        SwingUtilities.invokeLater(ui);
    }
}
