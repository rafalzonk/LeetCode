package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = 0;
        }
        List<List<Integer>> permutations = new ArrayList<>();
        permutations.add(asList(nums));

        int i = 0;
        while (i < nums.length) {
            if (indexes[i] < i) {
                swap(nums, i % 2 == 0 ? 0 : indexes[i], i);
                permutations.add(asList(nums));
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }

        return permutations;
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