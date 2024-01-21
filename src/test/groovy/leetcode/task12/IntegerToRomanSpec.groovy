package leetcode.task12;

import spock.lang.Specification;

class IntegerToRomanSpec extends Specification {

    IntegerToRoman solution = new IntegerToRoman()

    def "test solution"() {
        expect:
        result == solution.intToRoman(num)

        where:
        num  | result
        1    | "I"
        5    | "V"
        10   | "X"
        50   | "L"
        100  | "C"
        500  | "D"
        1000 | "M"
        4    | "IV"
        9    | "IX"
        40   | "XL"
        90   | "XC"
        400  | "CD"
        900  | "CM"
        8    | "VIII"
        13   | "XIII"
        888  | "DCCCLXXXVIII"
        1994 | "MCMXCIV"
        3999 | "MMMCMXCIX"

    }

}