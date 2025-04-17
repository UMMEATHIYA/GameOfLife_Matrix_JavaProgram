package org.example;

/**
 * Shape class represents a fixed pattern of 0s and 1s in Game of Life.
 */
public class Shape extends Matrix {
    private final String name;

    /**
     * Constructs a Shape with a name and a 2D binary matrix.
     *
     * @param name the name of the shape
     * @param data the shape data (must contain only 0s and 1s)
     * @throws IllegalArgumentException if data has non-0/1 values
     */
    public Shape(String name, int[][] data) {
        super(data);
        this.name = name;

        for (int[] row : data) {
            for (int val : row) {
                if (val != 0 && val != 1) {
                    throw new IllegalArgumentException("Shape must only contain 0 and 1.");
                }
            }
        }
    }

    public String getName() {
        return name;
    }
}

