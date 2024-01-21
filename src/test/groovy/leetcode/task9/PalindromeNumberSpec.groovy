package leetcode.task9;

import spock.lang.Specification;

class PalindromeNumberSpec extends Specification {
    PalindromeNumber solution = new PalindromeNumber()

    def "test solution"() {
        expect:
        result == solution.isPalindrome(x)

        where:
        x         | result
        1         | true
        11        | true
        121       | true
        120       | false
        -121      | false
        1221      | true
        999       | true
        123454321 | true
        123454322 | false
    }

}