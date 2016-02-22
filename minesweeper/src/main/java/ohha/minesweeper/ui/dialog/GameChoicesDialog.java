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
    //instead of setting all the time, only when okButton pushed. (if set)
    //or skip the ok? counter-intuitive?
    private JSlider gridSlider;
    private JSlider bombSlider;

    public GameChoicesDialog(Frame owner) {
        super(owner, "Game options", true);

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

        gridSlider = new JSlider(2, 16, 8);
        gridSlider.setMajorTickSpacing(2);
        gridSlider.setMinorTickSpacing(1);
        gridSlider.setPaintTicks(true);
        gridSlider.setPaintLabels(true);
        
        JLabel bombLabel = new JLabel("Amount of bombs:");
        
        bombSlider = new JSlider(0, 64, 10);
        bombSlider.setMajorTickSpacing(10);
        bombSlider.setMinorTickSpacing(1);
        bombSlider.setPaintTicks(true);
        bombSlider.setPaintLabels(true);

        JButton okButton = new JButton("Ok");

        GameChoicesListener listener = new GameChoicesListener(gridSlider, bombSlider);
        gridSlider.addChangeListener(listener);
        bombSlider.addChangeListener(listener);

        //okButton listener
        
        container.add(gridLabel);
        container.add(gridSlider);
        container.add(bombLabel);
        container.add(bombSlider);
        container.add(okButton);

    }

    public int getGridSize() {
        return this.gridSlider.getValue();
    }

    public int getBombAmount() {
        
        int gridsize = this.gridSlider.getValue();
        int max = gridsize*gridsize;
        
        if(bombSlider.getValue() > max) {
            return max;
        }
        
        return this.bombSlider.getValue();
    }

}
