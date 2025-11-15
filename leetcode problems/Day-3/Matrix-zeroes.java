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
    public int[][] setZeroes(int[][] matrix,int n,int m) {
       int row[]=new int[m];
       int col[]=new int[n];

        // First pass: mark rows & columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        // Second pass: set zeros based on marks
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
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
        int col0 = 1; // flag for first column
        // PASS 1: Mark rows and columns using first row and first col
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;  // mark that first column should be zero
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row
                    matrix[0][j] = 0; // mark column
                }
            }
        }
        // PASS 2: Use marks to update the matrix (skip first row & col)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // PASS 3: Handle first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        // PASS 4: Handle first column
        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
