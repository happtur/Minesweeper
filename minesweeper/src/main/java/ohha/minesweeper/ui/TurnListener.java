package ohha.minesweeper.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import ohha.minesweeper.logic.Game;

public class TurnListener implements ActionListener {

    private Game game;
    //get it from source? but then Object - JButton
    private JButton button;
    private JLabel statusdisplay;
    private GUI gui;
    private boolean first;

    public TurnListener(Game game, JButton button, JLabel display, GUI gui) {
        this.game = game;
        this.button = button;
        this.statusdisplay = display;
        this.gui = gui;
        this.first = true;
    }

    //stuff here or 'repaint'(?) grid or sthg? (especially if 0 -> turn surrounding)
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int[] coordinates = game.toCoordinates(command);
        if (first) {
            statusdisplay.setText("Playing");
            first = false;
        }
        if (!game.turn(coordinates[0], coordinates[1])) {
            if (game.isWon()) {
                statusdisplay.setText("Congratulations, you won!");
            } else {
                statusdisplay.setText("You lost");
            }
            gui.newGame(statusdisplay);
        } else if (game.isTurned(coordinates[0], coordinates[1])) {
            button.setText(String.valueOf(game.getValue(coordinates[0], coordinates[1])));
            button.setEnabled(false);
        }
    }

}
