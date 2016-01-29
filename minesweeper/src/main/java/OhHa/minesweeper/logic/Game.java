package OhHa.minesweeper.logic;

import OhHa.minesweeper.ui.TextUI;

public class Game {

    private Grid grid;
    private TextUI ui;

    void addUI(TextUI ui) {
        this.ui = ui;
    }

    public void start() {

        while (true) {
            this.grid = new Grid(8, 10);

            this.ui.start();
        }
    }

    public int getSizeOfGrid() {
        return this.grid.getSize();
    }

    public boolean isTurned(int x, int y) {
        return this.grid.getTile(x, y).isTurned();
    }

    public int getValue(int x, int y) {
        return this.grid.getTile(x, y).getValue();
    }

    public void turn(int x, int y) {
        this.grid.getTile(x, y).turn();
    }

}
