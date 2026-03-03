package leetcode.powx2n

import spock.lang.Specification

class PowerTest extends Specification {
    Power solution = new Power()

    def "test solution"() {
        expect:
        solution.myPow(x, n) == result as double

        where:
        x       | n  || result
//        2.0     | 10          || 1024.0
//        -2.0    | 10          || 1024.0
//        2.0     | 9           || 512.0
//        -2.0    | 9           || -512.0
//        2.1     | 3           || 9.261
//        2.0     | -2          || 0.25
//        1.0     | 80          || 1.0
//        123.456 | 0           || 1.0
//        123.456 | 1           || 123.456
//        2.0     | -200000000  || 0.0
//        2.0     | -2147483648 || 0.0
//        0.86429 | 18 || 0.07242
        1.13183 | 16 || 7.25269
    }
}
