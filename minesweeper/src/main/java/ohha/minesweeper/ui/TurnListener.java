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

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(first) {
            statusdisplay.setText("Playing");
            first = false;
        }
        if (!game.turn(command)) {
            if (game.isWon()) {
                statusdisplay.setText("Congratulations, you won!");
            } else {
                statusdisplay.setText("You lost");
                //stop current game
                //somewhere else? this style or?
            }
            gui.newGame(statusdisplay);
        }
        button.setText(String.valueOf(game.getValue(command)));
        button.setEnabled(false);
    }

}
