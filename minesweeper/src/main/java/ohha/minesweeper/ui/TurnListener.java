package ohha.minesweeper.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ohha.minesweeper.logic.Game;

/**
 * The class listens and reacts to left-clicks on the tile-buttons.
 */
public class TurnListener implements ActionListener {

    private Game game;
    private GridPanel grid;
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
    
    public TurnListener(Game game, GridPanel grid, DisplayPanel display, GUI gui) {
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
            if (game.isWon()) {
                display.setStatus("Congratulations, you won!");
            } else {
                display.setStatus("You lost");
            }
            gui.newGame(display);
        } else if (game.isTurned(coordinates[0], coordinates[1])) {
            grid.setTextOfButton(command, String.valueOf(game.getValue(coordinates[0], coordinates[1])));
            grid.setButtonAsEnabled(command, false);
        }
    }

}
