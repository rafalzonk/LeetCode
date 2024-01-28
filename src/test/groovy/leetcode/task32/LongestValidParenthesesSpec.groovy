package leetcode.task32;

import spock.lang.Specification;

class LongestValidParenthesesSpec extends Specification {

    LongestValidParentheses solution = new LongestValidParentheses()

    def "test solution"() {
        expect:
        result == solution.longestValidParentheses(s)

        where:
        s              | result
        ""             | 0
        ")("           | 0
        "(()"          | 2
        ")()())"       | 4
        "()(()"        | 2
        "(()(((()"     | 2
        "(()(((()))))" | 12
        "(())("        | 4
        "((())"        | 4
        "(()(((())())" | 8

    }
}