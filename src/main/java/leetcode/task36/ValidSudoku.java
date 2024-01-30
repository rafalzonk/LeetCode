package leetcode.task36;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static final int SIZE = 9;
    public static final int BOX_SIZE = 3;

    public boolean isValidSudoku(char[][] board) {
        int[][] sudokuBoard = new int[9][9];
        char c;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                c = board[i][j];
                if (c > 48 && c < 58) {
                    sudokuBoard[i][j] = c - 48;
                }
            }
        }

        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < SIZE; i++) {
            numbers.clear();
            for (int j = 0; j < SIZE; j++) {
                if (sudokuBoard[i][j] != 0) {
                    if (numbers.contains(sudokuBoard[i][j]))
                        return false;
                    numbers.add(sudokuBoard[i][j]);
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            numbers.clear();
            for (int j = 0; j < SIZE; j++) {
                if (sudokuBoard[j][i] != 0) {
                    if (numbers.contains(sudokuBoard[j][i]))
                        return false;
                    numbers.add(sudokuBoard[j][i]);
                }
            }
        }

        int n;
        for (int x = 0; x < BOX_SIZE; x++) {
            for (int y = 0; y < BOX_SIZE; y++) {
                numbers.clear();
                for (int i = 0; i < BOX_SIZE; i++) {
                    for (int j = 0; j < BOX_SIZE; j++) {
                        n = sudokuBoard[x * BOX_SIZE + i][y * BOX_SIZE + j];
                        if (n != 0) {
                            if (numbers.contains(sudokuBoard[x * BOX_SIZE + i][y * BOX_SIZE + j]))
                                return false;
                            numbers.add(sudokuBoard[x * BOX_SIZE + i][y * BOX_SIZE + j]);
                        }
                    }
                }
            }
        }

        return true;
    }
}
