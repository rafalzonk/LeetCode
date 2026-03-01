package leetcode.wildcardmatching

import spock.lang.Specification

class WildcardMatchingTest extends Specification {
    WildcardMatching solution = new WildcardMatching()

    def "test solution"() {
        expect:
        solution.isMatch(s, p) == result

        where:
        s                                                       | p                       || result
        "aa"                                                    | "a"                     || false
        "ss"                                                    | "*"                     || true
        "cb"                                                    | "?a"                    || false
        "adceb"                                                 | "*a*b"                  || true
        "acdcb"                                                 | "a*c?b"                 || false
        "aa"                                                    | "a*"                    || true
        ""                                                      | "*****"                 || true
        "abcabczzzde"                                           | "*abc???de*"            || true
        "a"                                                     | ""                      || false
        "bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab" | "b*b*ab**ba*b**b***bba" || false
    }
}
