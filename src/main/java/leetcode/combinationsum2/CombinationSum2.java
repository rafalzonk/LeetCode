package leetcode.combinationsum2;

import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        int[] convertedCandidates = convertCandidates(candidates);
        int currentNumber = 1;
        while (currentNumber <= target) {
            if (convertedCandidates[currentNumber] > 0) {
                innerCombinationSum2(convertedCandidates, target, currentNumber, res, new ArrayList<>());
            }
            currentNumber++;
        }

        return res;
    }

    private int[] convertCandidates(int[] candidates) {
        int[] converted = new int[51];
        for (int candidate : candidates) {
            converted[candidate]++;
        }

        return converted;
    }

    private void innerCombinationSum2(int[] candidates, int target, int currentNumber, List<List<Integer>> res, List<Integer> combination) {
        if (target == currentNumber) {
            combination.add(currentNumber);
            res.add(new ArrayList<>(combination));
            combination.removeLast();
        }
        if (currentNumber >= candidates.length || currentNumber > target)
            return;

        combination.add(currentNumber);
        candidates[currentNumber]--;

        int next = currentNumber;

        while (target - currentNumber >= next) {
            if (candidates[next] > 0) {
                innerCombinationSum2(candidates, target - currentNumber, next, res, combination);
            }
            next++;
        }

        candidates[currentNumber]++;
        combination.removeLast();
    }
}
