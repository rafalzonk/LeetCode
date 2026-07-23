package leetcode.jump_game;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 1 || nums[0] >= nums.length - 1)
            return true;

        int goal = nums.length - 1;
        int idx = goal;
        while (--idx != 0) {
            if (idx + nums[idx] >= goal) {
                goal = idx;
            }
        }

        return nums[0] >= goal;
    }
}
