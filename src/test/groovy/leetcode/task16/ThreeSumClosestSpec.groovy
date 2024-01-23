package leetcode.task16;

import spock.lang.Specification;

class ThreeSumClosestSpec extends Specification {

    ThreeSumClosest solution = new ThreeSumClosest()

    def "test solution"() {
        given:
        int[] nums = numsList

        expect:
        result == solution.threeSumClosest(nums, target)

        where:
        result | target | numsList
        2      | 1      | [-1, 2, 1, -4]
        0      | 1      | [0, 0, 0]
        3      | 3      | [0, 1, 2]
    }
}