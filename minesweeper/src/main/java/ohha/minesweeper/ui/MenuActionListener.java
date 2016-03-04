package ohha.minesweeper.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * The class listens for and reacts to actions in the menu.
 */
public class MenuActionListener implements ActionListener {
    
    private DisplayPanel display;
    private GUI gui;
    private InstructionsDialog dialog;

    /**
     * The constructor.
     *
     * @param display the game's status display
     * @param gui the main ui
     */
    public MenuActionListener(DisplayPanel display, GUI gui) {
        this.display = display;
        this.gui = gui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("new game")) {
            
            int answer = JOptionPane.showConfirmDialog(gui.getFrame(),
                    "Are you sure you want to start a new game?",
                    "New Game",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null);
            
            if (answer == JOptionPane.YES_OPTION) {
                gui.newGame(display);
                
            }
            
        } else if (e.getActionCommand().equals("rules")) {
            if (this.dialog == null) {
                this.dialog = new InstructionsDialog(gui.getFrame());
            }
            this.dialog.setVisible(true);
        }
    }
    
}
