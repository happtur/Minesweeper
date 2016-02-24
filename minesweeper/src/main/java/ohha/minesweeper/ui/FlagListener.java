
package ohha.minesweeper.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import ohha.minesweeper.logic.Game;

public class FlagListener implements MouseListener {
    private Game game;
    private DisplayPanel display;

    public FlagListener(Game game, DisplayPanel display) {
        this.game = game;
        this.display = display;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)) {
            
            if(e.getSource().getClass() == JButton.class) {
                JButton source = (JButton) e.getSource();
                
                String command = source.getActionCommand();
                int[] coordinates = game.toCoordinates(command);
                
                //make flag(x,y) to return boolean ?
                game.flag(coordinates[0], coordinates[1]);
                
                if(game.isFlagged(coordinates[0], coordinates[1])) {
                    //setIcon
                    source.setText("x");
                    display.oneLessBomb();
                } else {
                    //removeIcon
                    source.setText("");
                    display.oneMoreBomb();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
