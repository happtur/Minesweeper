package OhHa.minesweeper.logic;

import java.util.ArrayList;
import java.util.Random;

public class Grid {

    private ArrayList<ArrayList<Tile>> tiles;

    public Grid(int size, int bombs) {

        this.tiles = new ArrayList<>();
        createRowsAndTiles(size);
        createBombs(bombs);
        setValuesOfTiles();
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
    
    private void createBombs(int bombs) {
        int size = this.tiles.size();
        Random random = new Random();
        for (int i = 0; i < bombs; i++) {

            int x;
            int y;
            while (true) {
                x = random.nextInt(size);
                y = random.nextInt(size);

                if (!this.tiles.get(y).get(x).isBomb()) {
                    this.tiles.get(y).get(x).setAsBomb();
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

                this.tiles.get(i).get(j).setValue(adjacentBombs);

            }
        }
    }


    private boolean tileOnGrid(int x, int y) {
        return x < this.tiles.size() && x > -1 && y < this.tiles.size() && y >= 0;
    }
    
    public Tile getTile(int x, int y) {
        return this.tiles.get(x).get(y);
    }
    
    public int getSize() {
        return this.tiles.size();
    }

}
