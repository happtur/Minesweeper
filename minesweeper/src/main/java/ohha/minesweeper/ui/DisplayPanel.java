package ohha.minesweeper.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * The class holds the components that display the game's current status and
 * the integer ("amount of bombs in the game" - "amount of flagged tiles").
 */
public class DisplayPanel extends JPanel {

    private JLabel status;
    private JLabel bombsLeft;
    private int amountOfBombs;

    /**
     * The constructor, sets the status to "Playing" and displays
     * the total amount of bombs in the current game.
     * 
     * @param bombs the total amount of bombs in the game
     */
    public DisplayPanel(int bombs) {
        //super(new GridLayout(1,2));
        super(new FlowLayout(SwingConstants.TRAILING, 30, 5));

        this.bombsLeft = new JLabel(String.valueOf(bombs));
        this.status = new JLabel("Playing");
        this.amountOfBombs = bombs;

        this.add(this.status);        
        this.add(this.bombsLeft);
    }

    /**
     * The method changes the displayed status of the game to the new status.
     * 
     * @param newStatus the new status of the game
     */
    public void setStatus(String newStatus) {
        this.status.setText(newStatus);
    }

    /**
     * The method changes the displayed integer to the new integer. Is typically
     * called when a new game is begun and the total amount of bombs should be
     * displayed
     * 
     * @param bombs the new amount of bombs
     */
    public void setBombs(int bombs) {
        this.amountOfBombs = bombs;
        this.updateBombs();
    }

    /**
     * The displayed integer is decreased by 1. Typically called when a tile is 
     * flagged
     * 
     */
    public void oneLessBomb() {
        this.amountOfBombs--;
        this.updateBombs();
    }

    /**
     * The displayed integer is increased by 1. Typically called when a tile is 
     * unflagged
     */
    public void oneMoreBomb() {
        this.amountOfBombs++;
        this.updateBombs();
    }

    //security, not under 0?
    private void updateBombs() {
        this.bombsLeft.setText(String.valueOf(this.amountOfBombs));
    }

}
