package leetcode.nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        if (n == 2 || n == 3) {
            return Collections.emptyList();
        }
        if (n == 1) {
            return List.of(List.of("Q"));
        }

        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');

        List<List<String>> results = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            queens(board, 0, i, results);

        return results;
    }

    private void queens(char[][] board, int row, int column, List<List<String>> results) {
        board[row][column] = 'Q';
        if (row == board.length - 1) {
            recordResult(board, results);
        } else {
            for (int i = 0; i < column - 1; i++) {
                if (canInsert(board, row + 1, i)) {
                    queens(board, row + 1, i, results);
                }
            }
            for (int i = column + 2; i < board.length; i++) {
                if (canInsert(board, row + 1, i)) {
                    queens(board, row + 1, i, results);
                }
            }
        }
        board[row][column] = '.';
    }

    private boolean canInsert(char[][] board, int row, int column) {
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 'Q')
                return false;
        }
        for (int i = 1; i <= column && i <= row; i++) {
            if (board[row - i][column - i] == 'Q')
                return false;
        }
        for (int i = 1; i + column < board.length && i <= row; i++) {
            if (board[row - i][column + i] == 'Q')
                return false;
        }
        return true;
    }

    private void recordResult(char[][] board, List<List<String>> results) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(String.copyValueOf(row));
        }
        results.add(result);
    }
}