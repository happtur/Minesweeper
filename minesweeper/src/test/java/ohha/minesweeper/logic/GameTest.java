package ohha.minesweeper.logic;

import ohha.minesweeper.logic.Grid;
import ohha.minesweeper.logic.Game;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    Game game;
    Grid grid;
    
    @Before
    public void setUp() {
        grid = new ohha.minesweeper.logic.Grid(4, 5, new RandomStub(0,0,1,1,1,2,0,3,1,3));
    }

    @Test
    public void isWonReturnsFalseInTheBeginning() {
        game = new Game(3,2);
        assertEquals(false, game.isWon());
    }
    
    @Test
    public void getSizeOfGridReturnsTheCorrectValue() {
        game = new Game(5,0);
        assertEquals(5, game.getSizeOfGrid());
    }
    
    @Test
    public void isTurnedIsFalseForAllValuesOfXAndYInTheBeginning() {
        game = new Game(2,1);
        assertEquals(false, game.isTurned(0, 0)
                            && game.isTurned(0, 1)
                            && game.isTurned(1, 0)
                            && game.isTurned(1, 1));
    }
    
    @Test
    public void afterTurningATileItIsTurned() {
        game = new Game(2,1);
        game.turn(1,1);
        assertEquals(true, game.isTurned(1, 1));
    }
    
    @Test
    public void afterTurningATileTwiceItIsTurned() {
        game = new Game(3,1);
        game.turn(1,2);
        game.turn(1,2);
        assertEquals(true, game.isTurned(1, 2));
    }
    
    @Test
    public void isFlaggedReturnsFalseForAllValuesOfXAndYInTheBeginning() {
        game = new Game(2,1);
        assertEquals(false, game.isFlagged(0, 0)
                            && game.isFlagged(0, 1)
                            && game.isFlagged(1, 0)
                            && game.isFlagged(1, 1));
    }
    
    @Test
    public void afterFlaggingATileItIsFlagged() {
        game = new Game(2,1);
        game.flag(0, 0);
        assertEquals(true, game.isFlagged(0, 0));
    }
    
    @Test
    public void afterFlaggingATileTwiceItIsNotFlagged() {
        game = new Game(2,1);
        game.flag(0, 0);
        game.flag(0, 0);
        assertEquals(false, game.isFlagged(0, 0));
    }
    
    @Test
    public void getValueReturnsTheCorrectValue() {
        game = new Game(grid);
        assertEquals(true, game.getValue(3, 3) == 0
                        && game.getValue(3, 2) == 0
                        && game.getValue(2, 0) == 1
                        && game.getValue(0, 2) == 4
                        && game.getValue(2, 2) == 3
                        && game.getValue(1, 0) == 2
                        && game.getValue(2, 3) == 2);
    }
    
    @Test
    public void turningANonBombTileThatIsNotTheLastTileReturnsTrue() {
        game = new Game(grid);
        assertEquals(true, game.turn(2, 0)
                        && game.turn(0, 2)
                        && game.turn(3, 3));
    }
    
    @Test
    public void turningTheLastNonBombTileReturnsFalse() {
        game = new Game(grid);
        turnAllButOneNonBombTiles();
        assertEquals(false, game.turn(2, 1));
    }
    
    @Test
    public void turningABombReturnsFalse() {
        game = new Game(grid);
        assertEquals(true, !game.turn(0, 0)
                        && !game.turn(1, 3)
                        && !game.turn(1, 1));
    }
    
    @Test
    public void afterTurningTheLastNonBombTileIsWonReturnsTrue() {
        game = new Game(grid);
        turnAllButOneNonBombTiles();
        game.turn(2, 1);
        assertEquals(true, game.isWon());
    }
    
    @Test
    public void turningAFlaggedTileReturnsTrue() {
        game = new Game(grid);
        game.flag(2, 3);
        assertEquals(true, game.turn(2, 3));
    }

    
    @Test
    public void turningATileWithCoordinatesOutsideOfTheGridReturnsTrue() {
        game = new Game(2,0);
        assertEquals(true, game.turn(3, 0)
                        && game.turn(1, -2)
                        && game.turn(2, 2));
    }
    
    @Test
    public void toCoordinatesReturnsTheRightValues() {
        game = new Game(2,0);
        assertEquals(true, game.toCoordinates("1:2")[0] == 1
                        && game.toCoordinates("2:3")[1] == 3);
    }
    
    
    private void turnAllButOneNonBombTiles() {
        game.turn(1, 0);
        game.turn(2, 0);
        game.turn(3, 0);
        game.turn(0, 1);
        //game.turn(2, 1);
        game.turn(3, 1);
        game.turn(0, 2);
        game.turn(2, 2);
        game.turn(3, 2);
        game.turn(2, 3);
        game.turn(3, 3);
    }
    
    
}
