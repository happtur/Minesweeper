package ohha.minesweeper.logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * The class creates the tiles, sets the initial values and then stores them and
 * their respective positions.
 */
public class Grid {

    private ArrayList<ArrayList<Tile>> tiles;
    private int bombs;
    private Random random;

    public Grid(int size, int bombs, Random random) {

        this.bombs = bombs;
        this.random = random;
        this.tiles = new ArrayList<>();
        createRowsAndTiles(size);
        createBombs();
        setValuesOfTiles();
    }
    
    public Grid(int size, int bombs) {
        this(size, bombs, new Random());
    }

    private void createRowsAndTiles(int size) {
        for (int i = 0; i < size; i++) {
            ArrayList<Tile> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Tile());
            }
            this.tiles.add(row);
        }
    }
    
    private void createBombs() {
        int size = this.tiles.size();
        for (int i = 0; i < bombs; i++) {

            int x;
            int y;
            while (true) {
                x = this.random.nextInt(size);
                y = this.random.nextInt(size);

                if (!this.tiles.get(x).get(y).isBomb()) {
                    this.tiles.get(x).get(y).setAsBomb();
                    break;
                }
            }
        }
    }

    private void setValuesOfTiles() {
        int size = this.tiles.size();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (this.tiles.get(i).get(j).isBomb()) {
                    continue;
                }

                int adjacentBombs = countBombs(i, j);
                this.tiles.get(i).get(j).setValue(adjacentBombs);

            }
        }
    }

    private int countBombs(int i, int j) {
        int adjacentBombs = 0;
        for (int k = -1; k < 2; k++) {
            if (this.tileOnGrid(i - 1, j + k) && this.tiles.get(i - 1).get(j + k).isBomb()) {
                adjacentBombs++;
            }
            if (k != 0 && this.tileOnGrid(i, j + k) && this.tiles.get(i).get(j + k).isBomb()) {
                adjacentBombs++;
            }
            if (this.tileOnGrid(i + 1, j + k) && this.tiles.get(i + 1).get(j + k).isBomb()) {
                adjacentBombs++;
            }
        }
        return adjacentBombs;
    }


    /**
     * The method returns true if the tile with the coordinates that
     * correspond to the parameters is on the grid.
     *
     * @param x the x-coordinate of the tile
     * @param y the y-coordinate of the tile
     * 
     * @return boolean value for "the tile is on the grid"
     */
    
    public boolean tileOnGrid(int x, int y) {
        return x < this.tiles.size() && x > -1 && y < this.tiles.size() && y >= 0;
    }
    
    /**
     * The method returns the tile with the coordinates that
     * correspond to the parameters.
     *
     * @param x the x-coordinate of the tile
     * @param y the y-coordinate of the tile
     * 
     * @return the desired tile
     */
    
    public Tile getTile(int x, int y) {
        return this.tiles.get(x).get(y);
    }
    
    /**
     * The method returns the size of the axes of the grid.
     * 
     * @return the size of the grid's axes
     */
    
    public int getSize() {
        return this.tiles.size();
    }
    
    /**
     * The method returns the amount of bombs on the grid.
     * 
     * @return amount of bombs
     */
    
    public int amountOfBombs() {
        return this.bombs;
    }

}
