package ohha.minesweeper.ui;

import ohha.minesweeper.ui.frame.MainFrame;
import ohha.minesweeper.ui.frame.DisplayPanel;
import ohha.minesweeper.ui.grid.TurnListener;
import ohha.minesweeper.ui.grid.FlagListener;
import ohha.minesweeper.ui.grid.ButtonGrid;
import ohha.minesweeper.ui.dialog.GameChoicesDialog;
import ohha.minesweeper.logic.Game;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The class is the main GUI class.
 */
public class GUI implements Runnable {

    private MainFrame frame;
    private Game game;
    private DisplayPanel display;
    private ButtonGrid grid;
    private GameChoicesDialog dialog;
    private boolean first;

    @Override
    public void run() {
        game = new Game(8, 10);
        first = true;

        display = new DisplayPanel(game.amountOfBombs());
        this.createGrid();
        grid.setToolTipTextForButtons("Left-click turns, right-click flags");

        frame = new MainFrame(display, grid, this);
        frame.setVisible(true);
    }

    /**
     * The method starts and displays a new game.
     *
     */
    public void newGame() {

        first = true;
        this.createGame();

        this.createGrid();
        frame.replaceButtonGrid(grid);

        display.setBombs(game.amountOfBombs());

    }

    private void createGrid() {

        grid = new ButtonGrid(game.getSizeOfGrid());

        TurnListener tListener = new TurnListener(this);
        grid.addActionListenerToButtons(tListener);

        FlagListener fListener = new FlagListener(this);
        grid.addMouseListenerToButtons(fListener);
    }

    private void createGame() {

        if (this.dialog == null) {
            dialog = new GameChoicesDialog(frame);
        }
        dialog.setVisible(true);
        int size = dialog.getGridSize();
        int bombs = dialog.getBombAmount();
        dialog.setVisible(false);

        this.game = new Game(size, bombs);
    }

    /**
     * The method performs the actions that are to be performed when the player
     * flags/unflags a tile. I.e. the tile, display and button are updated
     *
     * @param button the button to be flagged
     */
    public void actionFlagTile(JButton button) {
        String command = button.getActionCommand();

        int[] coordinates = game.toCoordinates(command);

        if (game.flag(coordinates[0], coordinates[1])) {
            //setIcon
            button.setText("x");
            display.oneLessBomb();
        } else {
            //removeIcon
            button.setText("");
            display.oneMoreBomb();
        }
    }

    /**
     * The method performs the actions that are to be performed when the player
     * attempts to turn a tile.
     *
     * @param command the coordinates of the tile in question as String ("x:y")
     */
    public void actionTurnTile(String command) {
        int[] coordinates = game.toCoordinates(command);
        if (first) {
            display.setStatus("Playing");
            first = false;
        }
        if (!game.turn(coordinates[0], coordinates[1])) {
            gameIsOver(command, coordinates);

        } else if (game.isTurned(coordinates[0], coordinates[1])) {
            int value = game.getValue(coordinates[0], coordinates[1]);
            grid.setTextOfButton(command, String.valueOf(value));
            grid.setButtonAsEnabled(command, false);
        }
    }

    private void gameIsOver(String command, int[] coordinates) {
        if (game.isWon()) {
            display.setStatus("Congratulations, you won!");
            grid.setTextOfButton(command, String.valueOf(game.getValue(coordinates[0], coordinates[1])));
            grid.setAllButtonsAsEnabled(false);

        } else {
            //show the hidden bombs?
            display.setStatus("You lost");
            grid.setAllButtonsAsEnabled(false);
        }

        if (this.askIfNewGame()) {
            this.newGame();
        }
    }

    private boolean askIfNewGame() {

        int answer = JOptionPane.showConfirmDialog(frame,
                "Would you like to start a new game?",
                "New Game",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null);

        return answer == JOptionPane.YES_OPTION;
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
