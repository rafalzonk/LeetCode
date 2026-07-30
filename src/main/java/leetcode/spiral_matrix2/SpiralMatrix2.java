package leetcode.spiral_matrix2;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if (n == 1)
            return new int[][]{{1}};

        int[][] result = new int[n][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[n];
        }

        int edgeLength = n;
        int step = 1;

        for (int i = 0; i < edgeLength; i++) {
            result[0][i] = step++;
        }

        int x = 0;
        int y = n - 1;
        edgeLength--;

        while (edgeLength > 1) {
            for (int i = 1; i <= edgeLength; i++) { //down
                result[x + i][y] = step++;
            }
            x += edgeLength;
            for (int i = 1; i <= edgeLength; i++) { //left
                result[x][y - i] = step++;
            }
            y -= edgeLength;

            edgeLength--;

            for (int i = 1; i <= edgeLength; i++) { //up
                result[x - i][y] = step++;
            }
            x -= edgeLength;
            for (int i = 1; i <= edgeLength; i++) { //right
                result[x][y + i] = step++;
            }
            y += edgeLength;

            edgeLength--;
        }

        if (n % 2 == 0) {
            result[n / 2][n / 2] = step++;
            result[n / 2][n / 2 - 1] = step;
        }

        return result;
    }

}