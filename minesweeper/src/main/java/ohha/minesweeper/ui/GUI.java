package ohha.minesweeper.ui;

import ohha.minesweeper.logic.Game;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
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

        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        int size = this.game.getSizeOfGrid();
        GridLayout layout = new GridLayout(size, size, 5, 5);
        container.setLayout(layout);

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                JButton button = new JButton();
                button.setName(String.valueOf(x) + String.valueOf(y));
                container.add(button);
            }
        }

    }

}
