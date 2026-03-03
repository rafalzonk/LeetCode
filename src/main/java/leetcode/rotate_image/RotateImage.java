package leetcode.rotate_image;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int ring = 0; ring < size / 2; ring++) {
            int ringSize = matrix.length - 2 * ring;
            for (int j = 0; j < ringSize - 1; j++) {
                swap(matrix,
                        ring, ring + j,
                        ring + j, ring + ringSize - 1,
                        ring + ringSize - 1, ring + ringSize - 1 - j,
                        ring + ringSize - 1 - j, ring);
            }
        }
    }

    private void swap(int[][] matrix,
                      int x1, int y1,
                      int x2, int y2,
                      int x3, int y3,
                      int x4, int y4) {
        int tmp = matrix[x4][y4];
        matrix[x4][y4] = matrix[x3][y3];
        matrix[x3][y3] = matrix[x2][y2];
        matrix[x2][y2] = matrix[x1][y1];
        matrix[x1][y1] = tmp;
    }
}