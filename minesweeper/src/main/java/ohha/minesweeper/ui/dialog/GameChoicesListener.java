package ohha.minesweeper.ui.dialog;

import javax.swing.JLabel;
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
    private JLabel bombLabel;

    /**
     * The constructor.
     *
     * @param sizeSlider the slider where the user chooses the size of the grid
     * @param bombSlider the slider where the user chooses the amount of bombs
     * @param bombLabel the label located above the bombSlider, displaying information
     * about the slider and a suggestion
     */
    public GameChoicesListener(JSlider sizeSlider, JSlider bombSlider, JLabel bombLabel) {
        this.sizeSlider = sizeSlider;
        this.bombSlider = bombSlider;
        this.bombLabel = bombLabel;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == sizeSlider) {

            if (!sizeSlider.getValueIsAdjusting()) {
                int value = sizeSlider.getValue();
                int suggestion = (int) (value * value * 0.2);
                
                bombLabel.setText("Amount of bombs:     (suggestion: " + suggestion + ")");
                bombSlider.setMaximum(value * value);
            }
        }
    }
}
