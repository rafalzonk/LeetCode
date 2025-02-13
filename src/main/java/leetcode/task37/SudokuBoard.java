package leetcode.task37;

public class SudokuBoard {
    final static int MAX_SIZE = 9;
    private final Cell[][] sudokuBoard;

    Cell get(int x, int y) {
        return sudokuBoard[x][y];
    }

    SudokuBoard(char[][] board) {
        Cell[][] sudokuBoard = new Cell[MAX_SIZE][MAX_SIZE];

        for (int row = 0; row < MAX_SIZE; row++) {
            for (int col = 0; col < MAX_SIZE; col++) {
                if (board[row][col] == '.') {
                    sudokuBoard[row][col] = new Cell();
                } else {
                    sudokuBoard[row][col] = new Cell(board[row][col] - '0');
                }
            }
        }

        this.sudokuBoard = sudokuBoard;
    }

    boolean initialCleanUp() {
        boolean changed = false;
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                Cell cell = sudokuBoard[i][j];
                if (cell.isKnown()) {
                    putNumberInBoard(i, j, cell.getValue());
                    changed = true;
                }
            }
        }
        return changed;
    }

    boolean fillSingleDigitCells() {
        boolean changed = false;
        for (int x = 0; x < MAX_SIZE; x++) {
            for (int y = 0; y < MAX_SIZE; y++) {
                Cell cell = sudokuBoard[x][y];
                if (cell.hasOnlyOnePossible() && !cell.isKnown()) {
                    putNumberInBoard(x, y);
                    changed = true;
                }
            }
        }
        return changed;
    }

    boolean fillSingleOccurrences() {
        boolean changed = false;
        //rows
        for (int i = 0; i < MAX_SIZE; i++) {
            int[] potentialNumbers = new int[MAX_SIZE + 1];
            for (int j = 0; j < MAX_SIZE; j++) {
                if (!sudokuBoard[i][j].isKnown()) {
                    for (Integer n : sudokuBoard[i][j].getPotentialValues()) {
                        potentialNumbers[n]++;
                    }
                }
            }
            for (int p = 1; p < MAX_SIZE + 1; p++) {
                if (potentialNumbers[p] == 1) {
                    for (int j = 0; j < MAX_SIZE; j++) {
                        if (sudokuBoard[i][j].getPotentialValues().contains(p)) {
                            putNumberInBoard(i, j, p);
                            changed = true;
                        }
                    }
                }
            }
        }

        //columns
        for (int i = 0; i < MAX_SIZE; i++) {
            int[] potentialNumbers = new int[MAX_SIZE + 1];
            for (int j = 0; j < MAX_SIZE; j++) {
                if (!sudokuBoard[j][i].isKnown()) {
                    for (Integer n : sudokuBoard[j][i].getPotentialValues()) {
                        potentialNumbers[n]++;
                    }
                }
            }
            for (int p = 1; p < MAX_SIZE + 1; p++) {
                if (potentialNumbers[p] == 1) {
                    for (int j = 0; j < MAX_SIZE; j++) {
                        if (sudokuBoard[j][i].getPotentialValues().contains(p)) {
                            putNumberInBoard(j, i, p);
                            changed = true;
                        }
                    }
                }
            }
        }

        //regions
        for (int i = 0; i < MAX_SIZE / 3; i++) {
            for (int j = 0; j < MAX_SIZE / 3; j++) {
                changed |= fillSingleOccurrencesInRegion(3 * i, 3 * j);
            }
        }

        return changed;
    }

    private boolean fillSingleOccurrencesInRegion(int cornerX, int cornerY) {
        boolean changed = false;

        int[] potentialNumbers = new int[MAX_SIZE + 1];
        for (int i = 0; i < MAX_SIZE / 3; i++) {
            for (int j = 0; j < MAX_SIZE / 3; j++) {
                if (!sudokuBoard[cornerX + i][cornerY + j].isKnown()) {
                    for (Integer n : sudokuBoard[cornerX + i][cornerY + j].getPotentialValues()) {
                        potentialNumbers[n]++;
                    }
                }
            }
        }
        for (int p = 1; p < MAX_SIZE + 1; p++) {
            if (potentialNumbers[p] == 1) {

                for (int i = 0; i < MAX_SIZE / 3; i++) {
                    for (int j = 0; j < MAX_SIZE / 3; j++) {
                        if (sudokuBoard[cornerX + i][cornerY + j].getPotentialValues().contains(p)) {
                            putNumberInBoard(cornerX + i, cornerY + j, p);
                            changed = true;
                        }
                    }
                }
            }
        }

        return changed;
    }


    void putNumberInBoard(int x, int y, int number) {
        sudokuBoard[x][y].setKnownValue(number);
        cleanPotentialNumberFromBoard(x, y, number);
    }

    void putNumberInBoard(int x, int y) {
        Cell cell = sudokuBoard[x][y];
        cell.setKnownValue();
        cleanPotentialNumberFromBoard(x, y, cell.getValue());
    }

    private void cleanPotentialNumberFromCell(int x, int y, int number) {
        sudokuBoard[x][y].removePotential(number);
    }

    private void cleanPotentialNumberFromBoard(int x, int y, Integer n) {
        for (int i = 0; i < MAX_SIZE; i++) {
            sudokuBoard[i][y].removePotential(n);
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            sudokuBoard[x][i].removePotential(n);
        }

        int cornerX = 3 * (x / 3);
        int cornerY = 3 * (y / 3);
        for (int i = cornerX; i < cornerX + 3; i++) {
            for (int j = cornerY; j < cornerY + 3; j++) {
                sudokuBoard[i][j].removePotential(n);
            }
        }
    }

    char[][] toCharMatrix(char[][] board) {
        for (int row = 0; row < MAX_SIZE; row++) {
            for (int col = 0; col < MAX_SIZE; col++) {
                if (sudokuBoard[row][col].getValue() == 0) {
                    board[row][col] = '.';
                } else
                    board[row][col] = (char) (sudokuBoard[row][col].getValue() + 48);
            }
        }
        return board;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] row : sudokuBoard) {
            for (Cell cell : row) {
                sb.append(cell).append(" ");
            }
            sb.append("\n");
        }
        sb.append("\n");

        return sb.toString();
    }
}
