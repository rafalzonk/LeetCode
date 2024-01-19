package leetcode.task5;

import spock.lang.Specification;

class LongestPalindromicSubstringSpec extends Specification {
    LongestPalindromicSubstring solution = new LongestPalindromicSubstring()

    def "test solution"() {
        expect:
        result == solution.longestPalindrome(input)

        where:
        input      | result
        "a"        | "a"
        "aa"       | "aa"
        "aaaa"     | "aaaa"
        "dddddddd" | "dddddddd"
        "aba"      | "aba"
        "abba"     | "abba"
        "abcddcbc" | "bcddcb"
        "abcdcbc"  | "bcdcb"
        "abcd"     | "a"
        "abccd"    | "cc"
        "abcdefe"  | "efe"
        "abcdeffe" | "effe"
    }

}