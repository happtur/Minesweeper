package ohha.minesweeper.logic;

import java.util.Random;

/**
 * The class is the main logic class, in charge of the game.
 */
public class Game {

    private Grid grid;
    private int turnedTiles;

    /**
     * The constructor with a Grid-parameter, for testing.
     *
     * @param grid the grid of the game
     */
    public Game(Grid grid) {
        this.turnedTiles = 0;
        this.grid = grid;
    }

    /**
     * The constructor of Game.
     *
     * @param size the desired size of the game's grid's axes
     * @param bombs the amount of bombs in the game
     */
    public Game(int size, int bombs) {
        this.turnedTiles = 0;
        this.grid = new Grid(size, bombs);
    }

    /**
     * The method returns the size of the grid's axes. So if the grid's size is
     * 4*4, this method returns 4.
     *
     * @return size of grid's axes
     */
    public int getSizeOfGrid() {
        return this.grid.getSize();
    }

    /**
     * The method returns true if the tile with the coordinate-values that
     * correspond to the parameters is turned.
     *
     * @param x the x-coordinate of the tile
     * @param y the y-coordinate of the tile
     *
     * @return boolean value for "the tile is turned"
     */
    public boolean isTurned(int x, int y) {
        return this.grid.getTile(x, y).isTurned();
    }

    /**
     * The method turns the string given as a parameter into an int-array with
     * two elements, where the first element is the x-coordinate and the second
     * the y-coordinate.
     *
     * @param xy string in the format "1:2", where 1 is the x-coordinate and 2
     * is the y-coordinate
     *
     * @return array with two integers representing coordinates
     */
    public int[] toCoordinates(String xy) {
        String[] coordinates = xy.split(":");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        int[] coorInt = new int[]{x, y};
        return coorInt;
    }

    /**
     * The method returns the value of the tile with the coordinates that
     * correspond to the parameters.
     *
     * @param x the x-coordinate of the tile
     * @param y the y-coordinate of the tile
     *
     * @return the value of the tile
     */
    public int getValue(int x, int y) {
        return this.grid.getTile(x, y).getValue();
    }

    /**
     * The method tries to turn the tile with the specific coordinates given as
     * parameters. If the tile is a bomb or the last non-flagged, non-bomb the
     * method returns false, i.e. the game is over. Otherwise the game continues
     * and the method returns true
     *
     * @param x the x-coordinate of the tile
     * @param y the y-coordinate of the tile
     *
     * @return boolean value for "the game continues"
     */
    public boolean turn(int x, int y) {
        if (!this.grid.tileOnGrid(x, y)) {
            return true;
        }

        Tile toBeTurned = this.grid.getTile(x, y);
        if (toBeTurned.turn()) {

            if (toBeTurned.isBomb()) {
                return false;
            }

            this.turnedTiles++;

            if (this.isWon()) {
                return false;
            }
        }
        return true;
    }

    /**
     * The method calls the flag-method of the tile with the coordinates
     * corresponding to the parameters.
     *
     * @param x the x-coordinate of the tile
     * @param y the y-coordinate of the tile
     *
     * @return boolean value for "the tile is flagged"
     *
     */
    public boolean flag(int x, int y) {

        return this.grid.getTile(x, y).flag();
    }

    /**
     * The method returns true if the game is over and the player won.
     *
     * @return boolean value for "the game is won"
     */
    public boolean isWon() {
        int size = this.grid.getSize();
        int bombs = this.grid.amountOfBombs();
        if (size * size == bombs) {
            return false;
        }
        return this.turnedTiles == size * size - bombs;
    }

    /**
     * The method returns the amount of bombs in the game.
     *
     * @return amount of bombs
     */
    public int amountOfBombs() {
        return this.grid.amountOfBombs();
    }

}
