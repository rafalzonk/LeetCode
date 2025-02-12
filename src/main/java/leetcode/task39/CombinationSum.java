package leetcode.task39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        innerCombinationSum(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void innerCombinationSum(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> combination) {
        if (target == 0) {
            res.add(new ArrayList<>(combination));
        }
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            combination.add(candidates[i]);
            innerCombinationSum(candidates, target - candidates[i], i, res, combination);
            combination.removeLast();
        }
    }
}
