package leetcode.task36;

import spock.lang.Specification;

class ValidSudokuSpec extends Specification implements SudokuTestData {

    ValidSudoku solution = new ValidSudoku()

    def "test solution"() {
        expect:
        result == solution.isValidSudoku(board as char[][])

        where:
        result | board
        true | validBoard
        false | invalidBoard
    }

}