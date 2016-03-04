package ohha.minesweeper.ui.grid;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The class contains and manages the (tile)buttons.
 */
public class ButtonGrid extends JPanel {

    private HashMap<String, JButton> buttons;

    /**
     * The constructor. Creates the buttons and JPanel
     *
     * @param size the size of the axes
     */
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

    /**
     * Adds an ActionListener to all the buttons.
     *
     * @param listener the ActionListener
     */
    public void addActionListenerToButtons(ActionListener listener) {
        for (JButton button : this.buttons.values()) {
            button.addActionListener(listener);
        }
    }

    /**
     * Adds a MouseListener to all the buttons.
     *
     * @param listener the MouseListener
     */
    public void addMouseListenerToButtons(MouseListener listener) {
        for (JButton button : this.buttons.values()) {
            button.addMouseListener(listener);
        }
    }

    /**
     * Sets the text of the button with the given identifier.
     *
     * @param buttonIdentifier a String with the button's identifier (its
     * coordinates x and y as "x:y"
     *
     * @param text the text that is to be displayed by the button
     */
    public void setTextOfButton(String buttonIdentifier, String text) {
        this.buttons.get(buttonIdentifier).setText(text);
    }

    /**
     * Enables or disables the button with given identifier.
     *
     * @param buttonIdentifier a String with the button's identifier (its
     * coordinates x and y as "x:y"
     *
     * @param enabled true if aiming to enable the button, false if aiming to
     * disable
     */
    public void setButtonAsEnabled(String buttonIdentifier, boolean enabled) {
        this.buttons.get(buttonIdentifier).setEnabled(enabled);
    }

    /**
     * Sets the tooltiptext of all buttons to the given parameter.
     *
     * @param text the desired tooltiptext
     */
    public void setToolTipTextForButtons(String text) {
        for (JButton button : this.buttons.values()) {
            button.setToolTipText(text);
        }
    }

    /**
     * Enables or disables all the buttons in the grid.
     *
     * @param enabled true if aiming to enable the buttons, false if aiming to
     * disable
     */
    public void setAllButtonsAsEnabled(boolean enabled) {
        for (JButton button : this.buttons.values()) {
            button.setEnabled(enabled);
        }
    }
    
}
