package leetcode.task11;

import spock.lang.Specification;

class ContainerWithMostWaterSpec extends Specification {

    ContainerWithMostWater solution = new ContainerWithMostWater()

    def "test solution"() {
        given:
        int[] input = heights

        expect:
        result == solution.maxArea(input)

        where:
        heights                           | result
        [1, 1]                            | 1
        [1, 8, 6, 2, 5, 4, 8, 3, 7]       | 49
        [1, 8, 6, 2, 5, 4, 8, 3, 7, 0, 0] | 49

    }

}