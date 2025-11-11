//brute-force approach-O(n^3) time complexity and O(1) space complexity
//Brute-force = Compare + Shift manually → O(n³)
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n;  ) {
                if (nums[i] == nums[j]) {
                    // Shift elements to the left
                    for (int k = j; k < n - 1; k++) {
                        nums[k] = nums[k + 1];
                    }
                    n--; // reduce the size
                } else {
                    j++; // move to next if not duplicate
                }
            }
        }
        return n;
    }
}