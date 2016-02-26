package ohha.minesweeper.ui.dialog;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The class listens and reacts to the GameChoicesDialog, where the user inserts
 *  values for size of grid and amount of bombs.
 */
public class GameChoicesListener implements ChangeListener {

    private JSlider sizeSlider;
    private JSlider bombSlider;

    /**
     * The constructor.
     *
     * @param sizeSlider the slider where the user chooses the size of the grid
     * @param bombSlider the slider where the user chooses the amount of bombs
     */
    public GameChoicesListener(JSlider sizeSlider, JSlider bombSlider) {
        this.sizeSlider = sizeSlider;
        this.bombSlider = bombSlider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == sizeSlider) {

            if (!sizeSlider.getValueIsAdjusting()) {
                int value = sizeSlider.getValue();

                bombSlider.setMaximum(value * value);
            }
        }
    }
}
