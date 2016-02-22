package ohha.minesweeper.ui.dialog;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;

public class GameChoicesDialog extends JDialog {

    //save the values like this or simply in the JSliders? To be decided
    private int gridsize;
    private int bombamount;

    public GameChoicesDialog(Frame owner) {
        super(owner, "Game options", true);

        this.gridsize = 8;
        this.bombamount = 10;

        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 350));

        createComponents(this.getContentPane());

        this.pack();
        this.setVisible(true);
    }

    private void createComponents(Container container) {
        //clean this shit up :)
        container.setLayout(new GridLayout(5, 1));

        JLabel gridLabel = new JLabel("Size of grid axes:");

        JSlider gridSize = new JSlider(2, 16, 8);
        gridSize.setMajorTickSpacing(2);
        gridSize.setMinorTickSpacing(1);
        gridSize.setPaintTicks(true);
        gridSize.setPaintLabels(true);
        
        JLabel bombLabel = new JLabel("Amount of bombs:");
        
        JSlider amountOfBombs = new JSlider(0, 64, 10);
        amountOfBombs.setMajorTickSpacing(10);
        amountOfBombs.setMinorTickSpacing(1);
        amountOfBombs.setPaintTicks(true);
        amountOfBombs.setPaintLabels(true);

        JButton okButton = new JButton("Ok");

        GameChoicesListener listener = new GameChoicesListener(gridSize, amountOfBombs, this);
        gridSize.addChangeListener(listener);
        amountOfBombs.addChangeListener(listener);

        //okButton listener
        
        container.add(gridLabel);
        container.add(gridSize);
        container.add(bombLabel);
        container.add(amountOfBombs);
        container.add(okButton);

    }

    public void setGridSize(int size) {
        this.gridsize = size;
    }

    public void setBombAmount(int bombs) {
        this.bombamount = bombs;
    }

    public int getGridSize() {
        return this.gridsize;
    }

    public int getBombAmount() {
        int max = gridsize*gridsize;
        
        if(bombamount > max) {
            return max;
        }
        
        return this.bombamount;
    }

}
