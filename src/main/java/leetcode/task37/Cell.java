package leetcode.task37;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

class Cell {
    private static final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private List<Integer> potentialValues = new ArrayList<>();

    private Integer value = 0;

    Cell(Integer value) {
        this.value = value;
        potentialValues = emptyList();
    }

    Cell() {
        potentialValues.addAll(numbers);
    }

    //used for testing only
    Cell(List<Integer> potentialValues) {
        this.potentialValues = potentialValues;
    }

    public Integer getValue() {
        return value;
    }

    public List<Integer> getPotentialValues() {
        return potentialValues;
    }

    void setKnownValue(Integer value) {
        if (!potentialValues.isEmpty()) {
            this.value = value;
            this.potentialValues.clear();
        }
    }

    /*
    Make sure there is only one possible number left when calling this method
     */
    void setKnownValue() {
        if (!potentialValues.isEmpty()) {
            this.value = this.potentialValues.getFirst();
            this.potentialValues.clear();
        }
    }

    void removePotential(Integer n) {
        potentialValues.remove(n);
    }

    boolean isKnown() {
        return value != 0;
    }

    boolean hasOnlyOnePossible() {
        return potentialValues.size() <= 1;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell other) {
            return value.equals(other.value) && potentialValues.equals(other.potentialValues);
        }
        return false;
    }
}