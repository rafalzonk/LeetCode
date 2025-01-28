package leetcode.task37

import spock.lang.Shared
import spock.lang.Specification

abstract class SudokuSolverSpec extends Specification implements SudokuTestData {
    @Shared
    SudokuSolver solution


    def "test solution"() {
        when:
        solution.solveSudoku(board)

        then:
        expected == board

        where:
        board  | expected
        board1 | expected1
        board2 | expected2
    }
}

class ScanningSudokuSolverSpec extends SudokuSolverSpec {
    def setupSpec() {
        solution = new ScanningSudokuSolver()
    }
}

class CharBasedBruteForceSudokuSolverSpec extends SudokuSolverSpec {
    def setupSpec() {
        solution = new CharBasedBruteForceSudokuSolver()
    }
}

class BruteForceSudokuSolverSpec extends SudokuSolverSpec {
    def setupSpec() {
//        solution = new BruteForceSudokuSolver()
    }

    def "shouldCheckIfAMoveIsLegal"() {
        given:
        solution = new BruteForceSudokuSolver()

        expect:
        isLegal == solution.isLegalMove(boardInt, x, y, n)

        where:
        isLegal || x | y | n
        false   || 1 | 1 | 5
        false   || 4 | 4 | 4
        false   || 0 | 7 | 7
        true    || 1 | 1 | 2
        true    || 1 | 1 | 7
    }
}
