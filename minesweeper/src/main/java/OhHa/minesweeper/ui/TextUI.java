
package OhHa.minesweeper.ui;

import OhHa.minesweeper.logic.Game;
import java.util.Scanner;

public class TextUI {
    
    private Scanner scanner;
    private Game game;
    
    public TextUI(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        
        while(true) { 
            this.displayGame();
            this.receiveCommand();
        }
    }

    private void displayGame() {
        for(int y = 0; y < this.game.getSizeOfGrid(); y++) {
            for(int x = 0; x < this.game.getSizeOfGrid(); x++) {
                
                if(!this.game.isTurned(x,y)) {
                    System.out.print("*");
                } else {
                    System.out.print(this.game.getValue(x,y));
                }                
            }
            System.out.println("");
        }
        
        System.out.println("");
    }

    private void receiveCommand() {
        System.out.println("flip");
        System.out.print("x: ");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.print("y: ");
        int y = Integer.parseInt(scanner.nextLine());
        
        this.game.turn(x, y);        
    }
    
}
