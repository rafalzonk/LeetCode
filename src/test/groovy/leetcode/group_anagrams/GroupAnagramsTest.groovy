package leetcode.group_anagrams

import spock.lang.Specification

class GroupAnagramsTest extends Specification {
    GroupAnagrams solution = new GroupAnagrams();

    def "test solution"() {
        expect:
        solution.groupAnagrams(input as String[]) == result

        where:
        input                                      || result
//        ["eat", "tea", "tan", "ate", "nat", "bat"] || [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
        [""]                                       || [[""]]
        ["a"]                                      || [["a"]]
    }
}
