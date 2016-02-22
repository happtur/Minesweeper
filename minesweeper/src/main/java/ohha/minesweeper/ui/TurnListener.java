package ohha.minesweeper.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ohha.minesweeper.logic.Game;
import ohha.minesweeper.ui.ButtonGrid;
import ohha.minesweeper.ui.DisplayPanel;
import ohha.minesweeper.ui.GUI;

/**
 * The class listens and reacts to left-clicks on the tile-buttons.
 */
public class TurnListener implements ActionListener {

    private Game game;
    private ButtonGrid grid;
    private DisplayPanel display;
    private GUI gui;
    private boolean first;

    /**
     * The constructor.
     *
     * @param game the current game
     * @param grid the grid of buttons the listener listens to
     * @param display the game's status display
     * @param gui the main ui
     */
    public TurnListener(Game game, ButtonGrid grid, DisplayPanel display, GUI gui) {
        this.game = game;
        this.grid = grid;
        this.display = display;
        this.gui = gui;
        this.first = true;
    }

    //stuff here or 'repaint'(?) grid or sthg? (especially if 0 -> turn surrounding)
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int[] coordinates = game.toCoordinates(command);
        if (first) {
            display.setStatus("Playing");
            first = false;
        }
        if (!game.turn(coordinates[0], coordinates[1])) {
            gameIsOver(command, coordinates);
            
        } else if (game.isTurned(coordinates[0], coordinates[1])) {
            //if value == 0 --> get surrounding buttons, turn them (unless flagged?)?
            grid.setTextOfButton(command, String.valueOf(game.getValue(coordinates[0], coordinates[1])));
            grid.setButtonAsEnabled(command, false);
        }
    }

    private void gameIsOver(String command, int[] coordinates) {
        if (game.isWon()) {
            display.setStatus("Congratulations, you won!");
            grid.setTextOfButton(command, String.valueOf(game.getValue(coordinates[0], coordinates[1])));
            grid.setButtonAsEnabled(command, false);
            
        } else {
            display.setStatus("You lost");
        }
        
        if (this.askIfNewGame()) {
            gui.newGame(display);
        }
    }

    private boolean askIfNewGame() {

        int answer = JOptionPane.showConfirmDialog(gui.getFrame(),
                "Would you like to start a new game?",
                "New Game",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null);

        return answer == JOptionPane.YES_OPTION;
    }

}
