package org.example;

/**
 * BoolMatrixPrinter prints 0-1 matrices with actual values.
 */
public class BoolMatrixPrinter extends MatrixOutlinePrinter {

    /**
     * Prints a 0-1 matrix with actual values.
     *
     * @param matrix the boolean matrix
     * @return the formatted matrix string
     * @throws IllegalArgumentException if any cell is not 0 or 1
     */
    @Override
    public String print(Matrix matrix) {
        int[][] data = matrix.getData();

        // Check if all values are 0 or 1
        for (int[] row : data) {
            for (int val : row) {
                if (val != 0 && val != 1) {
                    throw new IllegalArgumentException("Matrix contains values other than 0 or 1.");
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // For each row, append the formatted row string to the StringBuilder
        for (int[] row : data) {
            sb.append(printRow(row)).append("\n");
        }
        return sb.toString();  // Return the entire formatted matrix
    }

    /**
     * Overrides the row printer to show 0s and 1s.
     *
     * @param row a row of integers
     * @return a string representation of the row
     */
    @Override
    protected String printRow(int[] row) {
        StringBuilder rowString = new StringBuilder();
        for (int val : row) {
            if (val != 0 && val != 1) {
                throw new IllegalArgumentException("Matrix contains non-binary value: " + val);
            }
            rowString.append(val);  // Append 0 or 1 to the row string
        }
        return rowString.toString();
    }


}