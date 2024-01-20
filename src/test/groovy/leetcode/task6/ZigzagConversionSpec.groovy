package leetcode.task6

import spock.lang.Shared;
import spock.lang.Specification;

abstract class ZigzagConversionSpec extends Specification {

    @Shared
    ZigzagConversion solution

    def "test solution"() {
        expect:
        result == solution.convert(input, rows);

        where:
        input                                                                                                                                                              | rows | result
        "PAYPALISHIRING"                                                                                                                                                   | 3    | "PAHNAPLSIIGYIR"
        "PAYPALISHIRING"                                                                                                                                                   | 2    | "PYAIHRNAPLSIIG"
        "PAYPALISHIRING"                                                                                                                                                   | 4    | "PINALSIGYAHRPI"
        "PAYPALISHIRING"                                                                                                                                                   | 1    | "PAYPALISHIRING"
        "PAYPALISHIRING"                                                                                                                                                   | 14   | "PAYPALISHIRING"
        "A"                                                                                                                                                                | 3    | "A"
        "ABCDE"                                                                                                                                                            | 3    | "AEBDC"
        "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers." | 3    | "Aiosrhem,tseoihartaaeeriwgrlasasnoctaoieplnrmiaodprs,ubroohreunefnttacneedhsmwynihrieto,iheeaalwnefrdutettpntainnwrdvdr.adew,anereqcustbaeeitdcntnlocojmsuuoddis"
    }
}

class ZigzagConversionWithArraySpec extends ZigzagConversionSpec {
    def setupSpec() {
        solution = new ZigzagConversionWithArray()
    }
}