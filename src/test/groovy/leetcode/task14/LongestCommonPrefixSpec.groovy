package leetcode.task14;

import spock.lang.Specification;

class LongestCommonPrefixSpec extends Specification {

    LongestCommonPrefix solution = new LongestCommonPrefix()

    def "test solution"() {
        given:
        String[] strings = input

        expect:
        result == solution.longestCommonPrefix(strings)

        where:
        input                               | result
        ["flower", "flow", "flight"]        | "fl"
        ["dog", "racecar", "car"]           | ""
        ["single string"]                   | "single string"
        ["abcde", "abcd", "abc", "ab", "a"] | "a"
    }

}