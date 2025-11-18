//Brute Force Approach: Rotate layer by layer
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int layer = 0; layer < n / 2; layer++) {
            int start = layer;
            int end = n - layer - 1;

            for(int i = start; i < end; i++) {
                int offset = i - start;

                int temp = matrix[start][i];  // top

                matrix[start][i] = matrix[end - offset][start]; // left → top
                matrix[end - offset][start] = matrix[end][end - offset]; // bottom → left
                matrix[end][end - offset] = matrix[i][end]; // right → bottom
                matrix[i][end] = temp; // top → right
            }
        }
    }
}


//Optimized Approach: Transpose the matrix and then reverse each row
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
    
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while(left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
