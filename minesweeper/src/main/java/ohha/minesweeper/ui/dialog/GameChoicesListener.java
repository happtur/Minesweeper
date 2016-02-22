package ohha.minesweeper.ui.dialog;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import ohha.minesweeper.ui.dialog.GameChoicesDialog;

public class GameChoicesListener implements ChangeListener {

    private JSlider sizeSlider;
    private JSlider bombSlider;

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
