package leetcode.task10;

import spock.lang.Specification;

class RegularExpressionMatchingSpec extends Specification {

    RegularExpressionMatching solution = new RegularExpressionMatching()

    def "test solution"() {
        expect:
        result == solution.isMatch(input, pattern)

        where:
        input   | pattern   | result
        "aaa"   | "aaa"     | true
        "aaa"   | "a*"      | true
        "aaa"   | "a"       | false
        "abcde" | ".*"      | true
        "aaa"   | "ab*a"    | false
        "aaa"   | "ab*a"    | false
        "a"     | "ab*"     | true
        "abc"   | "a***abc" | true

    }

}