package leetcode.permutations2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = 0;
        }
        Set<List<Integer>> permutations = new HashSet<>();
        permutations.add(asList(nums));

        int i = 0;
        while (i < nums.length) {
            if (indexes[i] < i) {
                int other = i % 2 == 0 ? 0 : indexes[i];
                if (nums[other] != nums[i]) {
                    swap(nums, other, i);
                    permutations.add(asList(nums));
                }
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }

        return permutations.stream().toList();
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private List<Integer> asList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int n : nums) {
            list.add(n);
        }

        return list;
    }
}