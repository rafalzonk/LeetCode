package leetcode.task28;

import spock.lang.Specification;

class FindTheIndexOfTheFirstOccurrenceInAStringSpec extends Specification {

    FindTheIndexOfTheFirstOccurrenceInAString solution = new FindTheIndexOfTheFirstOccurrenceInAString()

    def "test solution"() {
        expect:
        result == solution.strStr(haystack, needle)

        where:
        haystack     | needle  | result
        "sadbutsad"  | "sad"   | 0
        "sadbuttrue" | "true"  | 6
        "leetcode"   | "leeto" | -1
    }

}