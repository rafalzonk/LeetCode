package leetcode.task37;

import static leetcode.task37.SudokuBoard.MAX_SIZE;

public class ScanningSudokuSolver implements SudokuSolver {

    @Override
    public void solveSudoku(char[][] board) {
        SudokuBoard sudokuBoard = new SudokuBoard(board);

        if (sudokuBoard.initialCleanUp())
            while (scan(sudokuBoard)) ;

        sudokuBoard.toCharMatrix(board);
        if (!isComplete(board)) {
            solveBruteForce(board, -1, 0, sudokuBoard);
        }

        printBoard(board);
    }

    private boolean scan(SudokuBoard sudokuBoard) {
        boolean changed = sudokuBoard.fillSingleDigitCells();
        while (sudokuBoard.fillSingleDigitCells()) ;
        changed |= sudokuBoard.fillSingleOccurrences();
        while (sudokuBoard.fillSingleOccurrences()) ;

        return changed;
    }

    private boolean isComplete(char[][] board) {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (board[i][j] == '.')
                    return false;
            }
        }
        return true;
    }

    private boolean solveBruteForce(char[][] board, int x, int y, SudokuBoard sudokuBoard) {
        //find next empty cell in the current row
        for (int i = x + 1; i < MAX_SIZE; i++) {
            if (board[i][y] == '.') {
                return innerSolve(board, i, y, sudokuBoard);
            }
        }
        //find next empty cell in the next row
        for (int j = y + 1; j < MAX_SIZE; j++) {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (board[i][j] == '.') {
                    return innerSolve(board, i, j, sudokuBoard);
                }
            }
        }

        //no more empty cells
        return true;
    }

    private boolean innerSolve(char[][] board, int x, int y, SudokuBoard sudokuBoard) {
        for (Integer potentialValue : sudokuBoard.get(x, y).getPotentialValues()) {
            char n = (char) (potentialValue + 48);
            if (isLegalMove(board, x, y, n)) {
                board[x][y] = n;

                if (solveBruteForce(board, x, y, sudokuBoard))
                    return true;
                board[x][y] = '.';
            }
        }

        return false;
    }

    boolean isLegalMove(char[][] board, int x, int y, char n) {
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

    private void printBoard(char[][] board) {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
