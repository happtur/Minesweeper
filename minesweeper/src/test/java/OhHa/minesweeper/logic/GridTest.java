package OhHa.minesweeper.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GridTest {

    Grid grid;

    //Random random in constructor, stub? 
    
    @Test
    public void theConstructorAssignsTheCorrectValueToSize() {
        grid = new Grid(10,0);
        assertEquals(10, grid.getSize());
    }
}
