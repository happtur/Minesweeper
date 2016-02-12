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

    public TurnListener(Game game, JButton button, JLabel display) {
        this.game = game;
        this.button = button;
        this.statusdisplay = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (!game.turn(command)) {
            if (game.isWon()) {
                statusdisplay.setText("Congratulations, you won!");
            } else {
                statusdisplay.setText("You lost");
                //stop current game
                //somewhere else? this style or?
            }
        }
        button.setText(String.valueOf(game.getValue(command)));
        button.setEnabled(false);
    }

}
