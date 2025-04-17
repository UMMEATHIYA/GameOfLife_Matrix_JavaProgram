package org.example;

//
// Assignment 1
// Written by: Umme Athiya (Student ID: [your student ID])
// For SES350 Section [your section] – Spring 2025
//
import java.util.Arrays;

/**
 * Matrix class representing a 2D array of integers.
 */
public class Matrix {

    /** The 2D data array of the matrix. */
    private int[][] data;

    /**
     * Constructor to create a matrix with specified rows and columns.
     *
     * @param rows number of rows (must be >= 1)
     * @param cols number of columns (must be >= 1)
     * @throws IllegalArgumentException if rows or cols < 1
     */
    public Matrix(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Matrix must have at least 1 row and 1 column.");
        }
        this.data = new int[rows][cols];
    }

    /**
     * Constructor to initialize matrix with existing 2D array.
     *
     * @param data 2D integer array (must not be null, and at least 1x1)
     * @throws IllegalArgumentException if data is null or dimensions < 1
     */
    public Matrix(int[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Invalid data array.");
        }
        // Deep copy to prevent external modification
        this.data = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = Arrays.copyOf(data[i], data[i].length);
        }
    }

    /**
     * Gets the matrix data.
     *
     * @return a copy of the 2D array
     */
    public int[][] getData() {
        int[][] copy = new int[data.length][];
        for (int i = 0; i < data.length; i++) {
            copy[i] = Arrays.copyOf(data[i], data[i].length);
        }
        return copy;
    }

    /**
     * Sets the matrix data.
     *
     * @param data 2D integer array
     */
    public void setData(int[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Invalid data array.");
        }
        this.data = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = Arrays.copyOf(data[i], data[i].length);
        }
    }

    /**
     * Returns the number of rows in the matrix.
     *
     * @return number of rows
     */
    public int getRowCount() {
        return data.length;
    }

    /**
     * Returns the number of columns in the matrix.
     *
     * @return number of columns
     */
    public int getColumnCount() {
        return data[0].length;
    }
}

