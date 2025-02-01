package leetcode.task37

import spock.lang.Specification

class CellSpec extends Specification {

    def "shouldRemovePotentialNumbersWhenNumberIsSet"() {
        given:
        Cell cell = new Cell()

        expect:
        !cell.isKnown()
        cell.getPotentialValues().size() == 9
        cell.getPotentialValues() == [1, 2, 3, 4, 5, 6, 7, 8, 9]

        when:
        cell.setKnownValue(5)

        then:
        cell.isKnown()
        cell.hasOnlyOnePossible()
        cell.getValue() == 5
        cell.getPotentialValues().isEmpty()
    }

    def "shouldRemovePotentialValue"() {
        given:
        Cell cell = new Cell()

        expect:
        cell.getPotentialValues() == [1, 2, 3, 4, 5, 6, 7, 8, 9]

        when:
        cell.removePotential(4)

        then:
        cell.getPotentialValues() == [1, 2, 3, 5, 6, 7, 8, 9]
    }

    def "shouldNotOverwriteValueAfterItIsSet"() {
        given:
        Cell cell = new Cell()

        when:
        cell.setKnownValue(6)
        cell.setKnownValue(2)

        then:
        cell.getValue() == 6
    }

    def "shouldSetKnownValueWhenThereIsOnlyOnePotentialNumber"() {
        given:
        Cell cell = new Cell()

        when:
        for (i in 1..<9) {
            cell.removePotential(i)
        }

        then:
        cell.hasOnlyOnePossible()
        cell.getPotentialValues() == [9]
        cell.getValue() == 0

        when:
        cell.setKnownValue()

        then:
        cell.getValue() == 9
        cell.getPotentialValues().isEmpty()
    }

}
