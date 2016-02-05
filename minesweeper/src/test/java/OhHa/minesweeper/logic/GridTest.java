package OhHa.minesweeper.logic;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GridTest {

    Grid grid;
    
    @Test
    public void theConstructorAssignsTheCorrectValueToSize() {
        grid = new Grid(10,0);
        assertEquals(10, grid.getSize());
    }
    
    @Test
    public void theConstructorAssignsTheCorrectValueToAmountOfBombs() {
        grid = new Grid(4, 5);
        assertEquals(5, grid.amountOfBombs());
    }
    
    @Test
    public void ifATileIsNotChosenToBeSetAsABombItIsNotABomb() {
        grid = new Grid(3, 1, new RandomStub(0,0));
        assertEquals(true, !grid.getTile(0, 1).isBomb()
                            && !grid.getTile(1, 1).isBomb()
                            && !grid.getTile(1, 0).isBomb()
                            && !grid.getTile(1, 2).isBomb()
                            && !grid.getTile(2, 1).isBomb()
                            && !grid.getTile(2, 0).isBomb()
                            && !grid.getTile(2, 2).isBomb()
                            && !grid.getTile(0, 2).isBomb());
    }
    
    @Test
    public void ifATileIsChosenToBeSetAsABombItIsABomb() {
        grid = new Grid(5, 1, new RandomStub(0,0));
        assertEquals(true, grid.getTile(0, 0).isBomb());
    }
    
    @Test
    public void ifATileIsChosenToBeSetAsABombTwiceItIsABomb() {
        grid = new Grid(5, 2, new RandomStub(2,1,2,1,3,4));
        assertEquals(true, grid.getTile(2, 1).isBomb());
    }
    
    @Test
    public void theConstructorChoosesAnotherTileIfATileIsChosenToBeSetAsABombTwice() {
        grid = new Grid(5, 2, new RandomStub(2,1,2,1,3,4));
        assertEquals(true, grid.getTile(3, 4).isBomb());
    }
    
    @Test
    public void theTilesChosenToBeSetAsBombsAreBombs() {
        grid = new Grid(5, 4, new RandomStub(4,0,1,2,4,4,2,4));
        assertEquals(true, grid.getTile(4, 0).isBomb()
                            && grid.getTile(1, 2).isBomb()
                            && grid.getTile(4, 4).isBomb()
                            && grid.getTile(2, 4).isBomb());
    }
    
    @Test
    public void theValueOfANonBombIsZeroWhenNotConnectedToAnyBombs() {
        grid = new Grid(4,1, new RandomStub(0,0));
        assertEquals(true, grid.getTile(2, 2).getValue() == 0);
    }
    
    @Test
    public void theValueOfANonBombInTheMiddleIsEightWhenSurroundedByBombs() {
        grid = new Grid(3,8, new RandomStub(0,0,0,1,0,2,1,0,1,2,2,0,2,1,2,2));
        assertEquals(true, grid.getTile(1, 1).getValue() == 8);
    }
    
    @Test
    public void theValuesOfNonBombsAreCalculatedCorrectly() {
        grid = new Grid(6,13, new RandomStub(0,1,0,2,0,3,0,4,1,0,1,1,1,3,1,4,2,1,2,2,2,3,4,4,5,4));
        assertEquals(true, grid.getTile(0, 0).getValue() == 3
                            && grid.getTile(2, 0).getValue() == 3
                            && grid.getTile(3, 0).getValue() == 1
                            && grid.getTile(5, 0).getValue() == 0
                            && grid.getTile(1, 2).getValue() == 8
                            && grid.getTile(3, 2).getValue() == 3
                            && grid.getTile(4, 2).getValue() == 0
                            && grid.getTile(5, 3).getValue() == 2
                            && grid.getTile(2, 4).getValue() == 3
                            && grid.getTile(3, 4).getValue() == 2
                            && grid.getTile(0, 5).getValue() == 2
                            && grid.getTile(2, 5).getValue() == 1
                            && grid.getTile(4, 5).getValue() == 2);
    }
    
    @Test
    public void tileIsNotOnGridIfXNegative() {
        grid = new Grid(3,0);
        assertEquals(false, grid.tileOnGrid(-4, 2));
    }
    
    @Test
    public void tileIsNotOnGridIfYNegative() {
        grid = new Grid(3,0);
        assertEquals(false, grid.tileOnGrid(0, -1));
    }
    
    @Test
    public void tileIsNotOnGridIfXIsSize() {
        grid = new Grid(3,1);
        assertEquals(false, grid.tileOnGrid(3, 1));
    }
    
    @Test
    public void tileIsNotOnGridIfYIsSize() {
        grid = new Grid(3,1);
        assertEquals(false, grid.tileOnGrid(2, 3));
    }
    
    @Test
    public void tileIsNotOnGridIfXIsMoreThanSize() {
        grid = new Grid(3,1);
        assertEquals(false, grid.tileOnGrid(6, 2));
    }
    
    @Test
    public void tileIsNotOnGridIfYIsMoreThanSize() {
        grid = new Grid(3,1);
        assertEquals(false, grid.tileOnGrid(0, 4));
    }
}
