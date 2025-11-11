//Brute Force Approach-not optimal-uses extra space
import java.util.ArrayList;
import java.util.List;
class Solution {
    public void moveZeroes(int[] nums) {
        List<Integer> nonZeros = new ArrayList<>();
        int zeroCount = 0;
        for (int x : nums) {
            if (x != 0) 
                nonZeros.add(x);
            else 
                zeroCount++;
        }
        int idx = 0;
        for (int x : nonZeros) 
            nums[idx++] = x;
        while (zeroCount-- > 0) 
            nums[idx++] = 0;
    }
}

//Optimal Approach-Two-Pass In-Place
//Time: O(n) Space: O(1) Pros: in-place, simple.
//Cons: Might write non-zero elements over themselves when already in correct place (though that's fine).
class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}

//Optimal Approach-One-Pass In-Place
//Time: O(n) Space: O(1)
//Pros: Very efficient, one pass, minimal writes/swaps if optimized
class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // swap if needed
                int temp = nums[lastNonZero];
                nums[lastNonZero] = nums[i];
                nums[i] = temp;
                lastNonZero++;
            }
        }
    }
}


