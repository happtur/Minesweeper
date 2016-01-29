
package OhHa.minesweeper.ui;

import OhHa.minesweeper.logic.Grid;
import java.util.Scanner;

public class TextUI {
    
    private Scanner scanner;
    private Grid grid;
    
    public TextUI(Grid grid) {
        this.grid = grid;
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        
        while(true) { 
            this.displayGame();
            this.receiveCommand();
        }
    }

    private void displayGame() {
        for(int y = 0; y < this.grid.getSize(); y++) {
            for(int x = 0; x < this.grid.getSize(); x++) {
                
                if(!this.grid.isTurned(x,y)) {
                    System.out.print("*");
                } else {
                    System.out.print(this.grid.getValue(x,y));
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
        
        this.grid.turn(x, y);        
    }
    
}
