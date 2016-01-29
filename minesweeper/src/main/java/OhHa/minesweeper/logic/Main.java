
package OhHa.minesweeper.logic;

import OhHa.minesweeper.ui.TextUI;

public class Main {
    
    public static void main(String[] args) {
        Game game = new Game();
        TextUI ui = new TextUI(game);
        
        game.addUI(ui);
        game.start();
    }
}
