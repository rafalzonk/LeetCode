package leetcode.task8;

import spock.lang.Specification;

class StringToIntegerSpec extends Specification {

    StringToInteger solution = new StringToInteger()

    def "test solution"() {
        expect:
        result == solution.myAtoi(input)

        where:
        input                 | result
        "123"                 | 123
        "-123"                | -123
        "            4"       | 4
        "4"                   | 4
        "     +3"             | 3
        "     -3"             | -3
        "678dfgh"             | 678
        "    -9876bguk"       | -9876
        "   "                 | 0
        "   -"                | 0
        "   00013"            | 13
        "  -009"              | -9
        "-91283472332"        | -2147483648
        "9223372036854775808" | 2147483647
    }
}