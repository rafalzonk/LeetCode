package leetcode.insert_intervals

import spock.lang.Specification

class InsertIntervalsTest extends Specification {
    InsertIntervals solution = new InsertIntervals()

    def "test solution"() {
        expect:
        solution.insert(intervals as int[][], newInterval as int[]) == result as int[][]

        where:
        intervals                                   | newInterval || result
        [[1, 3], [6, 9]]                            | [2, 5]      || [[1, 5], [6, 9]]
        [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]] | [4, 8]      || [[1, 2], [3, 10], [12, 16]]
        [[1, 5]]                                    | [2, 3]      || [[1, 5]]
        [[1, 5]]                                    | [2, 7]      || [[1, 7]]
        [[1, 5]]                                    | [0, 3]      || [[0, 5]]
        [[2, 3], [5, 7]]                            | [0, 6]      || [[0, 7]]
    }
}
