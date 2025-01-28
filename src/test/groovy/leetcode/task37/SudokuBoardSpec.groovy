package leetcode.task37

import spock.lang.Specification

class SudokuBoardSpec extends Specification implements CellSudokuBoardTestData, SudokuTestData {

    def "shouldInstantiateBoard"() {
        given:
        def sudokuBoard = new SudokuBoard(board1)

        expect:
        compareSudokuBoard(sudokuBoard, initialBoard)
    }

    def "testInitialCleanup"() {
        given:
        def sudokuBoard = new SudokuBoard(board1)

        expect:
        sudokuBoard.initialCleanUp()
        compareSudokuBoard(sudokuBoard, boardAfterInitialCleanup)
    }
}
