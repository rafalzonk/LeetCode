package leetcode.nqueens

import spock.lang.Specification

class NQueensTest extends Specification {
    NQueens solution = new NQueens()

    def "test solution"() {
        expect:
        solution.solveNQueens(n) == result

        where:
        n || result
        1 || [["Q"]]
        2 || []
        3 || []
        4 || [[".Q..", "...Q", "Q...", "..Q."], ["..Q.", "Q...", "...Q", ".Q.."]]
    }
}
