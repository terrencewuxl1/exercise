package com.leecode.pratice;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int row = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][row - j - 1];
                matrix[i][row - j - 1] = temp;
            }
        }
    }
}

