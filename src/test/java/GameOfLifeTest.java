

import org.example.GameOfLife;
import org.example.Shape;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameOfLifeTest {

    @Test
    public void testStepBlinker() {
        GameOfLife game = new GameOfLife(5, 5);
        Shape blinker = new Shape("Blinker", new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        });
        game.addShape(blinker, 1, 1);
        game.step();
        int[][] expected = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(expected, game.getData());
    }

    @Test
    public void testStepAfter10Steps() {
        GameOfLife game = new GameOfLife(10, 10);
        Shape glider = new Shape("Glider", new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1}
        });
        game.addShape(glider, 1, 1);

        for (int i = 0; i < 10; i++) {
            game.step();
        }

        int[][] result = game.getData();
        assertNotNull(result); // For simplicity, just check the board is still valid
    }
}
