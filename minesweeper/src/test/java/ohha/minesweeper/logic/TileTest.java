package ohha.minesweeper.logic;



import ohha.minesweeper.logic.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TileTest {
    
    Tile tile;
    
    public TileTest() {
    }
    
    @Before
    public void setUp() {
        tile = new Tile();
    }

    @Test
    public void theConstructorSetsValueToZero() {
        assertEquals(0, tile.getValue());
    }
    
    @Test
    public void theConstructorSetsTurnedAsFalse() {
        assertEquals(false, tile.isTurned());
    }
    
    @Test
    public void flaggingAfterTheConstructorReturnsTrue() {
        assertEquals(true, tile.flag());
    }
    
    @Test
    public void afterOnlyTheConstructorTheTileIsNotABomb() {
        assertEquals(false, tile.isBomb());
    }
    
    @Test
    public void ifTheTileIsSetAsABombItsValueIsMinusOne() {
        tile.setAsBomb();
        assertEquals(-1, tile.getValue());
    }
    
    @Test
    public void ifTheTileIsSetAsABombTheMethodIsBombReturnsTrue() {
        tile.setAsBomb();
        assertEquals(true, tile.isBomb());
    }
    
    @Test
    public void ifTheValueIsSetAsAPositiveTheTileIsNotABomb() {
        tile.setValue(3);
        assertEquals(false, tile.isBomb());
    }
    
    @Test
    public void ifTheValueIsSetAsZeroTheTileIsNotABomb() {
        tile.setValue(0);
        assertEquals(false, tile.isBomb());
    }
    
    @Test
    public void theMethodSetValueChangesTheTilesValueCorrectlyWhenTheParameterIsZero() {
        tile.setValue(0);
        assertEquals(0, tile.getValue());
    }
    
    @Test
    public void theMethodSetValueChangesTheTilesValueCorrectlyWhenTheParameterIsPositive() {
        tile.setValue(4);
        assertEquals(4, tile.getValue());
    }
    
    @Test
    public void theMethodSetValueChangesTheTilesValueCorrectlyWhenCalledTwice() {
        tile.setValue(0);
        tile.setValue(6);
        assertEquals(6, tile.getValue());
    }
    
    @Test
    public void afterTurningTheTileItIsTurned() {
        tile.turn();
        assertEquals(true, tile.isTurned());
    }
    
    @Test
    public void turningTheTileOnceReturnsTrue() {
        assertEquals(true, tile.turn());
    }
    
    @Test
    public void turningTheTileTwiceReturnsFalse() {
        tile.turn();
        assertEquals(false, tile.turn());
    }
    
    @Test
    public void turningTheTileMultipleTimesReturnsFalse() {
        tile.turn();
        tile.turn();
        tile.turn();
        tile.turn();
        assertEquals(false, tile.turn());
    }
    
    @Test
    public void afterTurningTheTileTwiceItIsTurned() {
        tile.turn();
        tile.turn();
        assertEquals(true, tile.isTurned());
    }
    
    @Test
    public void aFlaggedTileCantBeTurned() {
        tile.flag();
        tile.turn();
        assertEquals(false, tile.isTurned());
    }
    
    @Test
    public void flaggingAFlaggedTileReturnsFalse() {
        tile.flag();        
        assertEquals(false, tile.flag());
    }
    
    @Test
    public void flaggingATileForTheThirdTimeReturnsTrue() {
        tile.flag();
        tile.flag();
        assertEquals(true, tile.flag());
    }
    
}
