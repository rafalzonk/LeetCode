package leetcode.task29;

import spock.lang.Specification;

class DivideTwoIntegersSpec extends Specification {

    DivideTwoIntegers solution = new DivideTwoIntegers()

    def "test solution"() {
        expect:
        result == solution.divide(dividend, divisor)

        where:
        dividend    | divisor     | result
        10          | 3           | 3
        -10         | 3           | -3
        -10         | -3          | 3
        7           | -3          | -2
        9           | 3           | 3
        -9          | -3          | 3
        4           | 4           | 1
        0           | -1          | 0
        0           | 1           | 0
        -2147483648 | -1          | 2147483647
        2147483647  | 2           | 1073741823
        1038925803  | -2147483648 | 0
        -2147483648 | 2           | -1073741824
        -2147483648 | 2147483647  | -1
    }

}