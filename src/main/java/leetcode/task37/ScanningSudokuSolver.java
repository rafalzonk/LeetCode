package leetcode.task37;

import static leetcode.task37.SudokuBoard.MAX_SIZE;

public class ScanningSudokuSolver implements SudokuSolver {

    @Override
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private void solve(char[][] board) {
        SudokuBoard sudokuBoard = new SudokuBoard(board);
        System.out.println(sudokuBoard);

        if (sudokuBoard.initialCleanUp())
            while (scan(sudokuBoard)) ;

        System.out.println(sudokuBoard);

        board = sudokuBoard.toCharMatrix();

        solveBruteForce(board, -1, 0);

        printBoard(board);
    }

    private boolean scan(SudokuBoard sudokuBoard) {
        return sudokuBoard.fillSingleDigitCells();
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean solveBruteForce(char[][] board, int x, int y) {
        //find next empty cell in the current row
        for (int i = x + 1; i < MAX_SIZE; i++) {
            if (board[i][y] == 0) {
                return innerSolve(board, i, y);
            }
        }
        //find next empty cell in the next row
        for (int j = y + 1; j < MAX_SIZE; j++) {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (board[i][j] == 0) {
                    return innerSolve(board, i, j);
                }
            }
        }

        //no more empty cells
        return true;
    }

    private boolean innerSolve(char[][] board, int x, int y) {
        for (int n = 49; n < 49 + MAX_SIZE; n++) { //from '1' to '9'
            if (isLegalMove(board, x, y, n)) {
                board[x][y] = (char) (n);

                if (solveBruteForce(board, x, y))
                    return true;
                board[x][y] = '.';
            }
        }
        return false;
    }

    boolean isLegalMove(char[][] board, int x, int y, int n) {
        board[x][y] = '.';
        for (int i = 0; i < MAX_SIZE; i++) {
            if (board[x][i] == n) {
                return false;
            }
        }

        for (int i = 0; i < MAX_SIZE; i++) {
            if (board[i][y] == n) {
                return false;
            }
        }

        int cornerX = 3 * (x / 3);
        int cornerY = 3 * (y / 3);
        for (int i = cornerX; i < cornerX + 3; i++) {
            for (int j = cornerY; j < cornerY + 3; j++) {
                if (board[i][j] == n) {
                    return false;
                }
            }
        }

        return true;
    }


}
