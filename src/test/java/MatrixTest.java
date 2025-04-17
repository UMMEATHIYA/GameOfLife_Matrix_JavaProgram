//
// Assignment 1 - MatrixTest
// Written by: Umme Athiya (Student ID: [your student ID])
// For SES350 Section [your section] – Spring 2025
//

import static org.junit.Assert.*;

import org.example.Matrix;
import org.junit.Test;

/**
 * Unit tests for Matrix class.
 */
public class MatrixTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorInvalidSize() {
        new Matrix(0, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullArray() {
        new Matrix((int[][]) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorEmptyArray() {
        new Matrix(new int[0][0]);
    }

    @Test
    public void testRowAndColumnCount() {
        Matrix m = new Matrix(3, 4);
        assertEquals(3, m.getRowCount());
        assertEquals(4, m.getColumnCount());
    }

    @Test
    public void testSetAndGetData() {
        int[][] data = {
                {1, 2},
                {3, 4}
        };
        Matrix m = new Matrix(data);
        assertArrayEquals(data, m.getData());

        int[][] newData = {
                {5, 6},
                {7, 8}
        };
        m.setData(newData);
        assertArrayEquals(newData, m.getData());
    }
}
