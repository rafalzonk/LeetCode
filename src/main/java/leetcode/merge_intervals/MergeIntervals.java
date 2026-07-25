package leetcode.merge_intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.sort;

public class MergeIntervals {
    private static IntervalComparator IC = new IntervalComparator();

    public int[][] merge(int[][] intervals) {
        sort(intervals, IC);

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals)
            mergeInterval(result, interval);

        return result.toArray(new int[result.size()][]);
    }

    private void mergeInterval(List<int[]> result, int[] interval) {
        for (int i = result.size() - 1; i >= 0; i--) {
            int[] resInterval = result.get(i); // [a2 b2]
            if (interval[1] >= resInterval[0]) {
                if (resInterval[1] < interval[0]) { // [a1 b1 a2 b2]
                    result.add(interval);
                    return;
                }
                if (resInterval[0] <= interval[0] && interval[1] <= resInterval[1]) { // [a2 a1 b1 b2]
                    return;
                }
                if (resInterval[1] < interval[1]) {
                    resInterval[1] = interval[1];
                    innerMergeForward(result, i);
                    if (resInterval[0] > interval[0])
                        innerMergeBackward(result, i);
                    return;
                }
            }
        }

        result.addFirst(interval);
    }

    private void innerMergeBackward(List<int[]> result, int from) {
        int[] interval = result.get(from);
        int prev = from - 1;
        while (prev >= 0 && (result.get(prev)[1] >= interval[0])) {
            if (interval[0] <= result.get(prev)[0]) {
                result.remove(prev);
                prev--;
            } else if (interval[0] > result.get(prev)[0] && interval[0] >= result.get(prev)[1]) {
                interval[0] = result.get(prev)[0];
                result.remove(prev);
                return;
            }
        }
    }

    private void innerMergeForward(List<int[]> result, int from) {
        int[] interval = result.get(from);
        int next = from + 1;
        while (next < result.size() && (result.get(next)[0] <= interval[1])) {
            if (interval[1] >= result.get(next)[1]) {
                result.remove(next);
            } else if (interval[1] >= result.get(next)[0]) {
                interval[1] = result.get(next)[1];
                result.remove(next);
                return;
            }
        }
    }

    static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }
    }
}