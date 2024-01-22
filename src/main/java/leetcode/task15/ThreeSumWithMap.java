package leetcode.task15;

import java.util.*;

/*
O(n^2)
 */
public class ThreeSumWithMap implements ThreeSum {

    @Override
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> numberOccurences = new HashMap<>();
        Arrays.stream(nums).forEach(number -> {
            if (numberOccurences.containsKey(number)) {
                Integer occur = numberOccurences.get(number);
                numberOccurences.put(number, occur + 1);
            } else {
                numberOccurences.put(number, 1);
            }
        });

        if (numberOccurences.containsKey(0) && numberOccurences.get(0) >= 3) {
            result.add(List.of(0, 0, 0));
        }

        int minusSum;

        for (Integer x : numberOccurences.keySet()) {
            for (Integer y : numberOccurences.keySet()) {
                if (y >= x && (!x.equals(y) || numberOccurences.get(x) > 1)) {
                    minusSum = -(x + y);
                    if (minusSum > x && minusSum >= y && numberOccurences.containsKey(minusSum)) {
                        if (!y.equals(minusSum) ||
                                numberOccurences.get(y) > 1) {
                            result.add(List.of(x, y, minusSum));
                        }
                    }
                }
            }
        }
        return result;
    }
}
