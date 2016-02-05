package OhHa.minesweeper.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    Game game;

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
    
}
