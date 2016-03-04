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
/**
 * The class manages input (grid size and amount of bombs) from the user.
 */
public class GameChoicesDialog extends JDialog {

    private JSlider sizeSlider;
    private JSlider bombSlider;

    /**
     * The constructor. Creates and sets visible
     *
     * @param owner the frame this JDialog is connected to
     */
    public GameChoicesDialog(Frame owner) {
        super(owner, "Game options", true);

        //save the values somewhere else so we can remove this when closing?
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 350));

        createComponents(this.getContentPane());

        this.pack();
        this.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(5, 1));

        JLabel gridLabel = new JLabel("Size of grid axes:");
        createSizeSlider();
        
        JLabel bombLabel = new JLabel("Amount of bombs:     (suggestion: 12)");
        createBombSlider();

        //JButton okButton = new JButton("Ok");

        //define the listener here instead?
        GameChoicesListener listener = new GameChoicesListener(sizeSlider, bombSlider, bombLabel);
        sizeSlider.addChangeListener(listener);

        //okButton listener
        
        container.add(gridLabel);
        container.add(sizeSlider);
        container.add(bombLabel);
        container.add(bombSlider);
        //container.add(okButton);

    }

    private void createBombSlider() {
        this.bombSlider = new JSlider(0, 64, 12);
        bombSlider.setMajorTickSpacing(10);
        bombSlider.setMinorTickSpacing(1);
        bombSlider.setPaintTicks(true);
        bombSlider.setPaintLabels(true);
    }

    private void createSizeSlider() {
        this.sizeSlider = new JSlider(2, 16, 8);
        sizeSlider.setMajorTickSpacing(2);
        sizeSlider.setMinorTickSpacing(1);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);
    }

    public int getGridSize() {
        return this.sizeSlider.getValue();
    }

    public int getBombAmount() {
        return this.bombSlider.getValue();
    }

}
