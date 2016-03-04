package ohha.minesweeper.ui.grid;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import ohha.minesweeper.ui.GUI;

/**
 * The class listens and reacts to right-clicks on the tile-buttons.
 */
public class FlagListener implements MouseListener {

    private GUI gui;

    /**
     * The constructor.
     *
     * @param gui the main gui object
     */
    public FlagListener(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {

            if (e.getSource().getClass() == JButton.class) {
                JButton source = (JButton) e.getSource();
                
                gui.actionFlagTile(source);
                
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
