
package OhHa.minesweeper.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomStub extends Random {
    
    private ArrayList<Integer> integers;
    
    public RandomStub(int... integers) {
        this.integers = new ArrayList<>();
        for(int i : integers) {
            this.integers.add(i);
        }
    }
    
    @Override
    public int nextInt(int bound) {
        return this.integers.remove(0);
    }
    
}
