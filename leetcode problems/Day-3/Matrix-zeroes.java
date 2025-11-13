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

//Using Extra Space-time complexity-O(m*n) ,space complexity-O(m+n)
//good for moderate constraints.
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        // First pass: mark rows & columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Second pass: set zeros based on marks
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

//Optimal Approach-time complexity-O(m*n) ,space complexity-O(1)
//Best for interviews & large constraints.
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col0 = false;

        // 1st pass: use first row & col as markers
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // mark row
                    matrix[0][j] = 0;  // mark col
                }
            }
        }

        // 2nd pass: set zeros using markers (skip first row & col)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // handle first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // handle first column
        if (col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
