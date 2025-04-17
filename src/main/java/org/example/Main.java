package org.example;


/**
 * Demonstrates Game of Life with various shapes.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameOfLife game = new GameOfLife(10, 10);
        BoolMatrixPrinter printer = new BoolMatrixPrinter();

        // Static Shapes
        Shape beehive = new Shape("Beehive", new int[][]{
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 0}
        });

        Shape boat = new Shape("Boat", new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        });

        // Dynamic Shapes
        Shape blinker = new Shape("Blinker", new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        });

        Shape glider = new Shape("Glider", new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1}
        });

        // Add shapes to board
        game.addShape(beehive, 0, 0);
        game.addShape(boat, 0, 5);
        game.addShape(blinker, 5, 1);
        game.addShape(glider, 6, 5);

        // Animate game
        while (true) {
            System.out.println(printer.print(game));
            game.step();
            Thread.sleep(500); // Pause to visualize
        }
    }
}
