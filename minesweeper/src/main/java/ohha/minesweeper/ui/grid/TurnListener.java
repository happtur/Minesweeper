package ohha.minesweeper.ui.grid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ohha.minesweeper.ui.GUI;

/**
 * The class listens and reacts to left-clicks on the tile-buttons.
 */
public class TurnListener implements ActionListener {

    private GUI gui;

    /**
     * The constructor.
     *
     * @param gui the main ui object
     */
    public TurnListener(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        gui.actionTurnTile(command);
    }

}
