package com.hussir.leetcode.part004;

/**
 * Description:
 *
 *      Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 *          Each row must contain the digits 1-9 without repetition.
 *          Each column must contain the digits 1-9 without repetition.
 *          Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class Question0036 {

    public boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {
            int[] rowSet = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int col = 0; col < 9; col++) {
                char curChar = board[row][col];
                if (curChar != '.') {
                    if (rowSet[curChar - '1'] != 0) {
                        return false;
                    } else {
                        rowSet[curChar - '1'] = 1;
                    }
                }
            }
        }

        for (int col = 0; col < 9; col++) {
            int[] colSet = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int row = 0; row < 9; row++) {
                char curChar = board[row][col];
                if (curChar != '.') {
                    if (colSet[curChar - '1'] != 0) {
                        return false;
                    } else {
                        colSet[curChar - '1'] = 2;
                    }
                }
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int[] squareSet = {0, 0, 0, 0, 0, 0, 0, 0, 0};
                for (int i = 0; i < 9; i++) {
                    char curChar = board[row * 3 + i / 3][col * 3 + i % 3];
                    if (curChar != '.') {
                        if (squareSet[curChar - '1'] != 0) {
                            return false;
                        } else {
                            squareSet[curChar - '1'] = 1;
                        }
                    }
                }
            }
        }

        return true;
    }
}