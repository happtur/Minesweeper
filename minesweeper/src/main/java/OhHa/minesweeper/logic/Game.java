package OhHa.minesweeper.logic;

import OhHa.minesweeper.ui.TextUI;

public class Game {

    private Grid grid;
    private TextUI ui;

    public void start() {

        while (true) {
            this.grid = new Grid(8, 10);
            this.ui = new TextUI(this.grid);

            this.ui.start();
            
            
        }
    }
}
