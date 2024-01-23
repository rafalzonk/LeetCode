package leetcode.task17;

import spock.lang.Specification;

class LetterCombinationsOfAPhoneNumberSpec extends Specification {

    LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber()

    def "test solution"() {
        expect:
        result == solution.letterCombinations(digits)

        where:
        digits | result
        "23"   | ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        ""     | []
        "2"    | ["a", "b", "c"]
    }

}