package org.example;
/**
 * MatrixOutlinePrinter prints the outline of a matrix (empty cells).
 */
public class MatrixOutlinePrinter implements MatrixPrinter {

    @Override
    public String print(Matrix matrix) {
        StringBuilder sb = new StringBuilder();
        int[][] data = matrix.getData();
        for (int[] row : data) {
            sb.append(printRow(row)).append("\n");
        }
        return sb.toString();
    }

    protected String printRow(int[] row) {
        StringBuilder rowString = new StringBuilder();
        for (int ignored : row) {
            rowString.append(" "); // just append spaces for each cell
        }
        return rowString.toString();
    }

}
