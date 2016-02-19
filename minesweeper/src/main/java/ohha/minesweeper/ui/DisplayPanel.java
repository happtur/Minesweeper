
package ohha.minesweeper.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * The class holds the components that display the game's current status.
 */

public class DisplayPanel extends JPanel{
    private JLabel status;
    private JLabel bombsLeft;
    private int amountOfBombs;
    
    public DisplayPanel(int bombs) {
        //super(new GridLayout(1,2));
        super(new FlowLayout(SwingConstants.LEADING, 30, 5));
        
        this.status = new JLabel("Playing");
        this.bombsLeft = new JLabel(String.valueOf(bombs));
        this.amountOfBombs = bombs;
        
        this.add(this.bombsLeft);
        this.add(this.status);        
    }
    
    public void setStatus(String newStatus) {
        this.status.setText(newStatus);
    }
    
    public void setBombs(int bombs) {
        this.amountOfBombs = bombs;
        this.updateBombs();
    }
    
    public void oneLessBomb() {
        this.amountOfBombs--;
        this.updateBombs();
    }
    
    public void oneMoreBomb() {
        this.amountOfBombs++;
        this.updateBombs();
    }
    
    private void updateBombs() {
        this.bombsLeft.setText(String.valueOf(this.amountOfBombs));
    }

}
