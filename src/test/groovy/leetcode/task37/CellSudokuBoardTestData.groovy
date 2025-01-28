package leetcode.task37

import static java.util.List.of
import static leetcode.task37.SudokuBoard.MAX_SIZE

trait CellSudokuBoardTestData {
    static Cell[][] initialBoard = [
            [new Cell(5), new Cell(3), new Cell(), new Cell(), new Cell(7), new Cell(), new Cell(), new Cell(), new Cell()],
            [new Cell(6), new Cell(), new Cell(), new Cell(1), new Cell(9), new Cell(5), new Cell(), new Cell(), new Cell()],
            [new Cell(), new Cell(9), new Cell(8), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(6), new Cell()],
            [new Cell(8), new Cell(), new Cell(), new Cell(), new Cell(6), new Cell(), new Cell(), new Cell(), new Cell(3)],
            [new Cell(4), new Cell(), new Cell(), new Cell(8), new Cell(), new Cell(3), new Cell(), new Cell(), new Cell(1)],
            [new Cell(7), new Cell(), new Cell(), new Cell(), new Cell(2), new Cell(), new Cell(), new Cell(), new Cell(6)],
            [new Cell(), new Cell(6), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(2), new Cell(8), new Cell()],
            [new Cell(), new Cell(), new Cell(), new Cell(4), new Cell(1), new Cell(9), new Cell(), new Cell(), new Cell(5)],
            [new Cell(), new Cell(), new Cell(), new Cell(), new Cell(8), new Cell(), new Cell(), new Cell(7), new Cell(9)]] as Cell[][]

    static Cell[][] boardAfterInitialCleanup = [
            [new Cell(5), new Cell(3), new Cell([1, 2, 4]), new Cell([2, 6]), new Cell(7), new Cell([2, 4, 6, 8]), new Cell([1, 4, 8, 9]), new Cell([1, 2, 4, 9]), new Cell([4, 8])],
            [new Cell(6), new Cell([2, 4, 7]), new Cell([2, 4, 7]), new Cell(1), new Cell(9), new Cell(5), new Cell([3, 4, 7, 8]), new Cell([2, 3, 4, 9]), new Cell([3, 4, 7, 8])],
            [new Cell([1, 2]), new Cell(9), new Cell(8), new Cell([2]), new Cell([3, 4]), new Cell([2, 4]), new Cell([1, 3, 4, 5, 7]), new Cell(6), new Cell([3, 4, 7])],
            [new Cell(8), new Cell([1, 5]), new Cell([1, 3, 5, 9]), new Cell([3, 5, 7, 9]), new Cell(6), new Cell([1, 4, 7]), new Cell([3, 4, 5, 7, 9]), new Cell([3, 4, 5, 9]), new Cell(3)],
            [new Cell(4), new Cell([2, 5]), new Cell([2, 5, 6, 9]), new Cell(8), new Cell([5]), new Cell(3), new Cell([5, 7, 9]), new Cell([3, 4, 5, 9]), new Cell(1)],
            [new Cell(7), new Cell([1, 3, 5]), new Cell([1, 3, 5, 9]), new Cell([3, 5, 9]), new Cell(2), new Cell([1, 4]), new Cell([3, 4, 5, 8, 9]), new Cell([3, 4, 5, 9]), new Cell(6)],
            [new Cell([1, 3, 9]), new Cell(6), new Cell([1, 3, 4, 5, 7, 9]), new Cell([3, 5, 7]), new Cell([3, 5]), new Cell([7]), new Cell(2), new Cell(8), new Cell([3, 4])],
            [new Cell([2, 3]), new Cell([2, 7, 8]), new Cell([2, 3, 7]), new Cell(4), new Cell(1), new Cell(9), new Cell([3, 6]), new Cell([3]), new Cell(5)],
            [new Cell([1, 2, 3]), new Cell([1, 2, 4, 5]), new Cell([1, 2, 3, 4, 5]), new Cell([2, 3, 5, 6]), new Cell(8), new Cell([2, 6]), new Cell([1, 3, 4, 6]), new Cell(7), new Cell(9)]] as Cell[][]

    static Cell[][] cellBoardExpected1 = [
            [new Cell(5), new Cell(3), new Cell(), new Cell(), new Cell(7), new Cell(), new Cell(), new Cell(), new Cell()],
            [new Cell(6), new Cell(), new Cell(), new Cell(1), new Cell(9), new Cell(5), new Cell(), new Cell(), new Cell()],
            [new Cell(1), new Cell(9), new Cell(8), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(6), new Cell()],
            [new Cell(8), new Cell(), new Cell(), new Cell(), new Cell(6), new Cell(), new Cell(), new Cell(), new Cell(3)],
            [new Cell(4), new Cell(), new Cell(), new Cell(8), new Cell(), new Cell(3), new Cell(), new Cell(), new Cell(1)],
            [new Cell(7), new Cell(), new Cell(), new Cell(), new Cell(2), new Cell(), new Cell(), new Cell(), new Cell(6)],
            [new Cell(), new Cell(6), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(2), new Cell(8), new Cell()],
            [new Cell(), new Cell(), new Cell(), new Cell(4), new Cell(1), new Cell(9), new Cell(), new Cell(), new Cell(5)],
            [new Cell(), new Cell(), new Cell(), new Cell(), new Cell(8), new Cell(), new Cell(), new Cell(7), new Cell(9)]] as Cell[][]


    boolean compareSudokuBoard(SudokuBoard actual, Cell[][] expected) {
        for (i in 0..<MAX_SIZE) {
            for (j in 0..<MAX_SIZE) {
                if (actual.get(i, j) == initialBoard[i][j])
                    return false;
            }
        }
        return true;
    }
}