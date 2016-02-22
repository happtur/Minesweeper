
package ohha.minesweeper.ui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonGrid extends JPanel {
    private HashMap<String, JButton> buttons;
    

    //make the frame's size more flexible and the buttons' constant?
    public ButtonGrid(int size) {
        super(new GridLayout(size, size, 3, 3));
        this.buttons = new HashMap<>();
        
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                JButton button = new JButton();
                
                String command = "" + x + ":" + y;
                button.setActionCommand(command);
                
                buttons.put(command, button);
                super.add(button);
            }
        }
        
    }
    
    public void addActionListenerToButtons(ActionListener listener) {
        for(JButton button : this.buttons.values()) {
            button.addActionListener(listener);
        }
    }
    
    public void setTextOfButton(String buttonIdentifier, String text) {
        this.buttons.get(buttonIdentifier).setText(text);
    }
    
    public void setButtonAsEnabled(String buttonIdentifier, boolean enabled) {
        this.buttons.get(buttonIdentifier).setEnabled(enabled);
    }
    
    public void setToolTipTextForButtons(String text) {
        for(JButton button : this.buttons.values()) {
            button.setToolTipText(text);
        }
    }
}
