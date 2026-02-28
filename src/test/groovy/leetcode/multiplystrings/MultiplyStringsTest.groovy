package leetcode.multiplystrings

import spock.lang.Specification

class MultiplyStringsTest extends Specification {
    MultiplyStrings solution = new MultiplyStrings()

    def "test solution"() {
        expect:
        solution.multiply(num1, num2) == result

        where:
        num1   | num2     || result
        "2"    | "3"      || "6"
        "123"  | "456"    || "56088"
        "852"  | "456"    || "388512"
        "2137" | "7312"   || "15625744"
        "749"  | "0"      || "0"
        "0"    | "523"    || "0"
        "1"    | "8432"   || "8432"
        "6294" | "1"      || "6294"
        "13"   | "875694" || "11384022"
    }
}
