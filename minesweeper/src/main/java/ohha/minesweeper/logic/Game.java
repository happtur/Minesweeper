package ohha.minesweeper.logic;

import java.util.Random;

/**
 * The class is the main logic class, in charge of the game.
 */
public class Game {

    private Grid grid;
    private int turnedTiles;

    Game(Grid grid) {
        this.turnedTiles = 0;
        this.grid = grid;
    }
    
    public Game(int size, int bombs) {
        this.turnedTiles = 0;
        this.grid = new Grid(size, bombs);
    }

    public int getSizeOfGrid() {
        return this.grid.getSize();
    }

    public boolean isTurned(int x, int y) {
        return this.grid.getTile(x, y).isTurned();
    }

    public int getValue(String xy) {
        String[] coordinates = xy.split(":");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        
        return getValue(x, y);
    }
    
    public int getValue(int x, int y) {
        return this.grid.getTile(x, y).getValue();
    }

    
    public boolean turn(String xy) {
        String[] coordinates = xy.split(":");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        
        return this.turn(x, y);
    }
    //param String xy --> divide and parseInt
    public boolean turn(int x, int y) {
        if (!this.grid.tileOnGrid(x, y)) {
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
        if (!this.grid.tileOnGrid(x, y)) {
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
