package ohha.minesweeper.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuActionListener implements ActionListener {

    private JMenuItem newGame;
    private JMenuItem gameRules;
    private DisplayPanel display;
    private GUI gui;

    public MenuActionListener(JMenuItem newGameMenuItem, JMenuItem gameRules, DisplayPanel display, GUI gui) {
        this.newGame = newGameMenuItem;
        this.gameRules = gameRules;
        this.display = display;
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {

            int answer = JOptionPane.showConfirmDialog(gui.getFrame(),
                    "Are you sure you want to start a new game?",
                    "New Game",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null);

            if (answer == JOptionPane.YES_OPTION) {
                gui.newGame(display);

            }

        } else if (e.getSource() == gameRules) {
            //show game instructions in new window
        }
    }

}
