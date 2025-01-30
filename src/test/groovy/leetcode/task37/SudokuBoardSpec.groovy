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

    def "testFillSingleDigitCells"() {
        given:
        def sudokuBoard = new SudokuBoard(board1)

        when:
        sudokuBoard.initialCleanUp()
        sudokuBoard.fillSingleDigitCells()

        then:
        compareSudokuBoard(sudokuBoard, boardAfterFillingSingleDigitCells)

        when:
        sudokuBoard.fillSingleDigitCells()

        then:
        compareSudokuBoard(sudokuBoard, boardAfterFillingSingleDigitCells2ndRound)

        when:
        sudokuBoard.fillSingleDigitCells()

        then:
        compareSudokuBoard(sudokuBoard, boardAfterFillingSingleDigitCells3rdRound)

        when:
        sudokuBoard.fillSingleDigitCells()

        then:
        compareSudokuBoard(sudokuBoard, boardAfterFillingSingleDigitCells4thRound)

        when:
        sudokuBoard.fillSingleDigitCells()

        then:
        compareSudokuBoard(sudokuBoard, boardAfterFillingSingleDigitCells5thRound)

        expect:
        !sudokuBoard.fillSingleDigitCells()
    }

}
