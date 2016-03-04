package ohha.minesweeper.ui;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * The dialog showing the instructions and rules of the game.
 */
public class InstructionsDialog extends JDialog {
    
    /**
     * The constructor, creates the components.
     * 
     * @param owner the main frame 
     */
    public InstructionsDialog(Frame owner) {
        super(owner, "Game instructions", false);
        
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setPreferredSize(new Dimension(510, 360));
        
        createComponents(this.getContentPane());
        
        this.pack();
    }
    
    private void createComponents(Container contentPane) {
        //should read from file..? too time consuming at the moment
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
        
        contentPane.add(textArea);
    }
    
}
