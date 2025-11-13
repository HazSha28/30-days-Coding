//Brute Force Approach-time complexity-O(m*n*(m+n)) ,space complexity-O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int MARK = Integer.MIN_VALUE;  // sentinel – an unlikely value

        // First pass: whenever you find zero, mark its row & column (except zeros) with MARK
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // mark row i
                    for (int col = 0; col < n; col++) {
                        if (matrix[i][col] != 0 && matrix[i][col] != MARK) {
                            matrix[i][col] = MARK;
                        }
                    }
                    // mark column j
                    for (int row = 0; row < m; row++) {
                        if (matrix[row][j] != 0 && matrix[row][j] != MARK) {
                            matrix[row][j] = MARK;
                        }
                    }
                }
            }
        }

        // Second pass: convert all MARK → 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == MARK) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

