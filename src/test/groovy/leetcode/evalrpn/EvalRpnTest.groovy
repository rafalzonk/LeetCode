package leetcode.evalrpn

import spock.lang.Specification

class EvalRpnTest extends Specification {
    EvalRpn solution = new EvalRpn()

    def "test solution"() {
        expect:
        solution.evalRPN(tokens as String[]) == result

        where:
        tokens                                                                || result
        ["2", "1", "+", "3", "*"]                                             || 9
        ["4", "13", "5", "/", "+"]                                            || 6
        ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"] || 22
    }
}
