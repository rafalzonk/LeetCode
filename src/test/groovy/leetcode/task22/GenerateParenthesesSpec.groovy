package leetcode.task22;

import spock.lang.Specification

import static java.util.Collections.sort;

class GenerateParenthesesSpec extends Specification {

    GenerateParentheses solution = new GenerateParentheses()

    def "test solution"() {
        expect:
        sort(result) == sort(solution.generateParenthesis(n))

        where:
        n | result
        1 | ["()"]
        2 | ["()()", "(())"]
        3 | ["()()()", "()(())", "(())()", "((()))"]
        4 | ["()()()()", "()()(())", "()(())()", "(())()()", "()((()))", "((()))()", "(((())))"]
    }

}