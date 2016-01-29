
package OhHa.minesweeper.logic;

public class Tile {
    
    private int value;
    private boolean turned;
    private boolean flagged;
    
    public Tile() {
        this.value = 0;
        this.turned = false;
        this.flagged = false;
    }
    
    public void setAsBomb() {
        this.value = -1;
    }
    
    public boolean isBomb() {
        return this.value == -1;
    }
    
    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    //boolean? turned?
    public void turn() {
        if(!this.flagged) {
            this.turned = true;
        }
    }
    
    public void flag() {
        this.flagged = !this.flagged;
    }
    
    public boolean isTurned() {
        return this.turned;
    }
    
    public boolean isFlagged() {
        return this.flagged;
    }
    
}
