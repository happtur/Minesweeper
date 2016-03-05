package ohha.minesweeper.ui.frame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import ohha.minesweeper.ui.GUI;

/**
 * The class listens for and reacts to actions in the menu.
 */
public class MenuActionListener implements ActionListener {
    
    private GUI gui;
    private JDialog dialog;

    /**
     * The constructor.
     *
     * @param gui the main ui
     */
    public MenuActionListener(GUI gui) {
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
                gui.newGame();
                
            }
            
        } else if (e.getActionCommand().equals("rules")) {
            if (this.dialog == null) {
                this.createDialog();
            }
            this.dialog.setVisible(true);
        }
    }

    private void createDialog() {
        this.dialog = new JDialog(gui.getFrame(), "Instructions", false);
        
        dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dialog.setPreferredSize(new Dimension(510, 360));
        
        JTextArea textArea = new JTextArea(
                " The purpose of the game is to turn (by left-clicking them) every tile in the grid except the\n"
                + " ones that represent bombs. Every turned non-bomb tile displays the number of bombs\n"
                + " adjacent to it. If you turn a bomb-tile the game is lost.\n"
                + " To help not accidentally turn bombs, you can flag (by right-clicking) tiles which makes\n"
                + " them impossible to turn. You can also unflag (also right-clicking) the flagged tiles.\n"
                + "\n"
                + " To help you keep count of the undiscovered bombs a counter, that starts at the total\n"
                + " amount of bombs and decreases when you flag a tile, is displayed in the top left corner.\n"
                + "\n"
                + " When the game is over, either won or lost, you will be asked if you'd like to play a\n"
                + " new game. If you choose to do this a new window will pop up prompting you to decide\n"
                + " the size of the grid and the amount of bombs you'd like. This is done by sliding\n"
                + " the arrow along the scale.\n"
                + "\n"
                + " If for some reason you want to start a new game at any other time you may also find\n"
                + " the \"New Game\" button in the menu."
                + "\n"
                + " Good luck and enjoy! :)");
        
        textArea.setEditable(false);
        dialog.getContentPane().add(textArea);
        dialog.pack();
    }
    
}
