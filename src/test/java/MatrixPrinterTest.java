
import org.example.BoolMatrixPrinter;
import org.example.Matrix;
import org.example.MatrixOutlinePrinter;
import org.example.MatrixPrinter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for MatrixPrinter classes.
 */
public class MatrixPrinterTest {

    @Test
    public void testOutlinePrinter3x4() {
        Matrix matrix = new Matrix(3, 4);
        MatrixPrinter printer = new MatrixOutlinePrinter();
        String expected = "    \n    \n    \n"; // 3 rows of 4 spaces
        assertEquals(expected, printer.print(matrix));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoolPrinterInvalidMatrix() {
        int[][] invalidData = {
                {0, 2},
                {1, 0}
        };
        Matrix matrix = new Matrix(invalidData);
        MatrixPrinter printer = new BoolMatrixPrinter();
        printer.print(matrix);
    }

    @Test
    public void testBoolPrinterValidMatrices() {
        int[][] data1 = {
                {0, 1, 0},
                {1, 0, 1}
        };
        int[][] data2 = {
                {1},
                {0}
        };
        MatrixPrinter printer = new BoolMatrixPrinter();

        Matrix matrix1 = new Matrix(data1);
        String expected1 = "010\n101\n";
        assertEquals(expected1, printer.print(matrix1));

        Matrix matrix2 = new Matrix(data2);
        String expected2 = "1\n0\n";
        assertEquals(expected2, printer.print(matrix2));
    }
}
