package leetcode.task20;

import spock.lang.Specification;

class ValidParenthesesSpec extends Specification {

    ValidParentheses solution = new ValidParentheses()

    def "test solution"() {
        expect:
        result == solution.isValid(s)

        where:
        s          | result
        "({[]})"   | true
        "()"       | true
        ")("       | false
        "[[[[]]]"  | false
        "[[[[]]]]" | true
        "()[]{}"   | true
        "(]"       | false
    }
}