//Brute Force Approach-not optimal
//Time Complexity: O(n^2)
//Space Complexity: O(1)
public class MaxSubarraysum {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += nums[j];
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }
}

//Optimal Solution: ‘Kadane’s Algorithm’ (Time: O(n), Space: O(1))
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;
        for (int i : nums) {
            currSum = Math.max(i, currSum + i);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
