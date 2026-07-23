package leetcode.spiral_matrix

import spock.lang.Specification

class SpiralMatrixTest extends Specification {

    SpiralMatrix solution = new SpiralMatrix()

    def "test solution"() {
        expect:
        solution.spiralOrder(matrix as int[][]) == result

        where:
        matrix                                        || result
        [[1, 2, 3], [4, 5, 6], [7, 8, 9]]             || [1, 2, 3, 6, 9, 8, 7, 4, 5]
        [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]] || [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
        [[1]]                                         || [1]
        [[1], [2], [3], [4]]                          || [1, 2, 3, 4]
        [[1, 2, 3, 4, 5]]                             || [1, 2, 3, 4, 5]
        [[1, 2], [3, 4], [5, 6]]                      || [1, 2, 4, 6, 5, 3]
        [[1, 2, 3], [4, 5, 6]]                        || [1, 2, 3, 6, 5, 4]
    }
}
