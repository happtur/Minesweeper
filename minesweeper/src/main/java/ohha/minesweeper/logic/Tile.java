package ohha.minesweeper.logic;

/**
 * The class stores and enables changes to the values of the properties of
 * tiles. These are the 'value' (i.e. the number of adjacent bombs or -1),
 * boolean 'turned' and boolean 'flagged
 */
public class Tile {

    private int value;
    private boolean turned;
    private boolean flagged;

    /**
     * The constructor sets value as 0 and both turned and flagged as false.
     */
    public Tile() {
        this.value = 0;
        this.turned = false;
        this.flagged = false;
    }

    /**
     * The method marks the tile as a bomb.
     */
    public void setAsBomb() {
        this.value = -1;
    }

    /**
     * The method is used to see if this is set as a bomb.
     *
     * @return boolean value of "this tile is a bomb"
     */
    public boolean isBomb() {
        return this.value == -1;
    }

    /**
     * The method sets the value (that represents the number of adjacent bombs)
     * as the input.
     *
     * @param value The input, future value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * The method returns the value (i.e. the number of adjacent bombs or -1 if
     * the tile is a bomb) of the tile.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * The method attempts to turn the tile. A flagged or already turned tile
     * cannot be turned
     *
     * @return boolean value of 'the attempt was successful'
     */
    public boolean turn() {
        if (!this.flagged && !this.turned) {
            this.turned = true;
            return true;
        }
        return false;
    }

    /**
     * The method flags an unflagged tile and unflags a flagged tile.
     * 
     * @return boolean value of 'the tile is flagged'
     */
    public boolean flag() {
        this.flagged = !this.flagged;
        return this.flagged;
    }

    /**
     * The methods is used to see if the tile is turned.
     *
     * @return boolean value of 'the tile is turned'
     */
    public boolean isTurned() {
        return this.turned;
    }

}
