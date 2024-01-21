package leetcode.task11;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxCapacity = 0;
        int capacity;

        while (left < right) {
            capacity = min(height[left], height[right]) * (right - left);
            maxCapacity = max(maxCapacity, capacity);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxCapacity;
    }
}
