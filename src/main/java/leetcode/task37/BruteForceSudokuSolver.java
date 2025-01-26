package leetcode.task37;

public class BruteForceSudokuSolver implements SudokuSolver {

    private final static int MAX_SIZE = 9;


    @Override
    public void solveSudoku(char[][] board) {
        int[][] sudokuBoard = toIntMatrix(board);

        printBoard(sudokuBoard);

        solve(sudokuBoard, -1, 0);

        printBoard(sudokuBoard);

        toCharMatrix(sudokuBoard, board);
    }

    private boolean solve(int[][] board, int x, int y) {
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

    private boolean innerSolve(int[][] board, int x, int y) {
        for (int n = 1; n <= MAX_SIZE; n++) {
            if (isLegalMove(board, x, y, n)) {
                board[x][y] = n;

                if (solve(board, x, y))
                    return true;
                board[x][y] = 0;
            }
        }
        return false;
    }

    boolean isLegalMove(int[][] board, int x, int y, int n) {
        board[x][y] = 0;
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

    private void printBoard(int[][] board) {
        System.out.println();
        for (int x = 0; x < MAX_SIZE; x++) {
            for (int y = 0; y < MAX_SIZE; y++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
    }

    private int[][] toIntMatrix(char[][] board) {
        int[][] sudokuBoard = new int[MAX_SIZE][MAX_SIZE];
        for (int x = 0; x < MAX_SIZE; x++) {
            for (int y = 0; y < MAX_SIZE; y++) {
                if (board[x][y] == '.') {
                    sudokuBoard[x][y] = 0;
                } else
                    sudokuBoard[x][y] = board[x][y] - '0';
            }
        }

        return sudokuBoard;
    }

    private char[][] toCharMatrix(int[][] intBoard, char[][] charBoard) {
        for (int x = 0; x < MAX_SIZE; x++) {
            for (int y = 0; y < MAX_SIZE; y++) {
                charBoard[x][y] = (char) (intBoard[x][y] + '0');
            }
        }
        return charBoard;
    }
}
