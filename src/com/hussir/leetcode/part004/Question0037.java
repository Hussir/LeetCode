package com.hussir.leetcode.part004;

/**
 * Description:
 *
 *      Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 *      A sudoku solution must satisfy all of the following rules:
 *
 *          Each of the digits 1-9 must occur exactly once in each row.
 *          Each of the digits 1-9 must occur exactly once in each column.
 *          Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 *          Empty cells are indicated by the character '.'.
 */
public class Question0037 {

    public void solveSudoku(char[][] board) {

        if (board == null) return;

        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
            for (int colIdx = 0; colIdx < 9; colIdx++) {
                if (board[rowIdx][colIdx] == '.') {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, rowIdx, colIdx, num)) {
                            board[rowIdx][colIdx] = (char) ('0' + num);
                            if (!solve(board)) {
                                board[rowIdx][colIdx] = '.';
                            } else {
                                return true;
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int rowIdx, int colIdx, int num) {

        int startRowIdx = (rowIdx / 3) * 3;
        int startColIdx = (colIdx / 3) * 3;

        for (int i = 0; i < 9; i++) {
            if (board[rowIdx][i] == '0' + num) return false;
            if (board[i][colIdx] == '0' + num) return false;
            if (board[startRowIdx + i / 3][startColIdx + i % 3] == '0' + num) return false;
        }

        return true;
    }
}