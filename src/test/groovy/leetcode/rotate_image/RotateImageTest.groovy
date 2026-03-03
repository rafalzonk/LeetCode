package leetcode.rotate_image

import spock.lang.Specification

class RotateImageTest extends Specification {
    RotateImage solution = new RotateImage()

    def "test solution"() {
        given:
        int[][] input = matrix

        when:
        solution.rotate(input)

        then:
        result as int[][] == input

        where:
        matrix                                                          || result
        [[1, 2, 3], [4, 5, 6], [7, 8, 9]]                               || [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
        [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]] || [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]
    }
}
