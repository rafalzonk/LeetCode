package leetcode.task38

import spock.lang.Specification

class CountAndSaySpec extends Specification {

    CountAndSay solution = new CountAndSay()

    def "test solution"() {
        expect:
        result.equals(solution.countAndSay(n))

        where:
        n | result
        1 | "1"
        2 | "11"
        3 | "21"
        4 | "1211"
    }
}
