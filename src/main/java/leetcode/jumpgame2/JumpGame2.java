package leetcode.jumpgame2;

public class JumpGame2 {
    public int jump(int[] nums) {
        int steps = 0;
        int currentIndex = 0;
        int nextIndex;

        while (currentIndex < nums.length - 1) {
            nextIndex = currentIndex + nums[currentIndex];
            if (nextIndex >= nums.length - 1)
                return steps + 1;

            for (int i = 1; i < nums[currentIndex]; i++) {
                if (nums[currentIndex + i] > 0 &&
                        currentIndex + i + nums[currentIndex + i] > nextIndex + nums[nextIndex]) {
                    nextIndex = currentIndex + i;
                }
            }

            currentIndex = nextIndex;
            steps++;
        }

        return steps;
    }
}
