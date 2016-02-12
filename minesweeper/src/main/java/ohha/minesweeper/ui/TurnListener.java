
package ohha.minesweeper.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import ohha.minesweeper.logic.Game;

public class TurnListener implements ActionListener{
    
    private Game game;
    //get it from source? but then Object - JButton, (JButton)? :/
    private JButton button;

    public TurnListener(Game game, JButton button) {
        this.game = game;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        game.turn(command);
        button.setText(String.valueOf(game.getValue(command)));
        button.setEnabled(false);       
    }
    
}
