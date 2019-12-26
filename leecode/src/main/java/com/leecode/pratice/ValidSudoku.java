package com.leecode.pratice;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        List<Character> rowlist;
        List<Character> collist;
        List<Character>[] square = new List[9];
        for (int i = 0; i < 9; i++) square[i] = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rowlist = new ArrayList<>();
            collist = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rowlist.contains(board[i][j])) {
                        return false;
                    } else {
                        rowlist.add(board[i][j]);
                    }
                }
                if (board[j][i] != '.') {
                    if (collist.contains(board[j][i])) {
                        return false;
                    } else {
                        collist.add(board[j][i]);
                    }
                }
                if (board[i][j] != '.') {
                    int area = (i / 3) * 3 + j / 3;
                    if (square[area].contains(board[i][j])) {
                        return false;
                    } else {
                        square[area].add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[] a1 = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] a2 = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        char[] a3 = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        char[] a4 = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] a5 = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        char[] a6 = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char[] a7 = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] a8 = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] a9 = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        char[][] a = new char[][]{a1, a2, a3, a4, a5, a6, a7, a8, a9};
        System.out.println(isValidSudoku(a));
    }
}
