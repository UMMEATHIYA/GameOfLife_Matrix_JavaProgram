package org.example;

/**
 * GameOfLife simulates Conway's Game of Life on a grid.
 */
public class GameOfLife extends Matrix {

    /**
     * Constructor for GameOfLife field.
     * @param rows number of rows
     * @param cols number of columns
     */
    public GameOfLife(int rows, int cols) {
        super(rows, cols);
    }

    /**
     * Places a shape onto the game field at given (x, y) position.
     *
     * @param shape the shape to place
     * @param row top-left row index
     * @param col top-left column index
     */
    public void addShape(Shape shape, int row, int col) {
        int[][] field = getData();
        int[][] shapeData = shape.getData();
        int shapeRows = shapeData.length;
        int shapeCols = shapeData[0].length;

        if (row + shapeRows > getRowCount() || col + shapeCols > getColumnCount()) {
            throw new IllegalArgumentException("Shape does not fit on the field.");
        }

        for (int i = 0; i < shapeRows; i++) {
            for (int j = 0; j < shapeCols; j++) {
                field[row + i][col + j] = shapeData[i][j];
            }
        }

        setData(field);
    }

    /**
     * Runs one step of Game of Life rules.
     */
    public void step() {
        int[][] current = getData();
        int rows = getRowCount();
        int cols = getColumnCount();
        int[][] nextGen = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = countLiveNeighbors(current, i, j);

                if (current[i][j] == 1) {
                    nextGen[i][j] = (liveNeighbors == 2 || liveNeighbors == 3) ? 1 : 0;
                } else {
                    nextGen[i][j] = (liveNeighbors == 3) ? 1 : 0;
                }
            }
        }

        setData(nextGen);
    }

    private int countLiveNeighbors(int[][] data, int x, int y) {
        int count = 0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < data.length && ny >= 0 && ny < data[0].length) {
                count += data[nx][ny];
            }
        }
        return count;
    }
}
