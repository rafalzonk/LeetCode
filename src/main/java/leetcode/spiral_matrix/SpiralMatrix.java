package leetcode.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = 0, w = 0, e = matrix[0].length - 1, s = matrix.length - 1;
        List<Integer> ret = new ArrayList<>();

        while (n < s && w < e) {
            for (int i = w; i <= e; i++) { //go west
                ret.add(matrix[n][i]);
            }
            n++;
            for (int i = n; i <= s; i++) { //go south
                ret.add(matrix[i][e]);
            }
            e--;

            for (int i = e; i >= w; i--) { //go east
                ret.add(matrix[s][i]);
            }
            s--;
            for (int i = s; i >= n; i--) { //go north
                ret.add(matrix[i][w]);
            }
            w++;
        }

        if (n == s) {
            if (matrix.length % 2 == 0) {
                for (int i = e; i >= w; i--) {
                    ret.add(matrix[s][i]);
                }
            } else {
                for (int i = w; i <= e; i++) {
                    ret.add(matrix[n][i]);
                }
            }
        } else if (w == e) {
            if (matrix[0].length % 2 == 0) {
                for (int i = s; i >= n; i--) {
                    ret.add(matrix[i][w]);
                }
            } else {
                for (int i = n; i <= s; i++) {
                    ret.add(matrix[i][e]);
                }
            }
        }

        return ret;
    }
}