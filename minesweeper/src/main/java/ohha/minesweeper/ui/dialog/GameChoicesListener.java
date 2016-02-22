
package ohha.minesweeper.ui.dialog;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import ohha.minesweeper.ui.dialog.GameChoicesDialog;

public class GameChoicesListener implements ChangeListener {
    private JSlider sizeSlider;
    private JSlider bombSlider;
    private GameChoicesDialog dialog;

    public GameChoicesListener(JSlider sizeSlider, JSlider bombSlider, GameChoicesDialog dialog) {
        this.sizeSlider = sizeSlider;
        this.bombSlider = bombSlider;
        this.dialog = dialog;
    }
    

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == sizeSlider) {
            
            if(!sizeSlider.getValueIsAdjusting()) {
                int value = sizeSlider.getValue();
                
                bombSlider.setMaximum(value*value);                
                dialog.setGridSize(value);
            }
            
        } else if(e.getSource() == bombSlider) {
            
            if(!bombSlider.getValueIsAdjusting()) {
                dialog.setBombAmount(bombSlider.getValue());
                
            }
        }
    }
    
}
