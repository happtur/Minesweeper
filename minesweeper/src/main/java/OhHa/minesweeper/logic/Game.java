package OhHa.minesweeper.logic;

import OhHa.minesweeper.ui.TextUI;

public class Game {

    private Grid grid;
    private TextUI ui;
    private int turnedTiles;

    public Game() {
        this.turnedTiles = 0;
    }

    void addUI(TextUI ui) {
        this.ui = ui;
    }

    public void start() {

        this.grid = new Grid(8, 10);

        this.ui.start();

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

    public boolean turn(int x, int y) {
        if(!this.grid.tileOnGrid(x, y)) {
            return true;
        }
        
        Tile toBeTurned = this.grid.getTile(x, y);
        if (toBeTurned.turn()) {
            this.turnedTiles++;

            if (toBeTurned.isBomb() || this.isWon()) {
                return false;
            }
        }
        return true;
    }

    public void flag(int x, int y) {
        if(!this.grid.tileOnGrid(x, y)) {
            return;
        }
        this.grid.getTile(x, y).flag();
    }

    public boolean isWon() {
        int size = this.grid.getSize();
        return this.turnedTiles == size * size - this.grid.amountOfBombs();
    }

    public boolean isFlagged(int x, int y) {
        return this.grid.getTile(x, y).isFlagged();
    }

}
