Brute force approach,Time: O(n³),Space: O(1)
not optimal beecause it re-sum all elements — too slow for large inputs
class solution{
    public int kSumSubarrays(int[] arr, int k) {
       int c=0;
       for(int start=0;start<arr.length;start++){
        for(int end=0;end<arr.length;end++){
            int sum=0;
            for(int l=start;l<=end;l++){
                sum+=arr[l];
            }
            if(sum==k){
                c++;
            }
        }
       }
       return c;
    }
}

//Better approach,Time: O(n²),Space: O(n)
//using prefix sum to avoid re-summing elements
//Why No-  Still quadratic — will time out for large arrays (up to 20,000).

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int[] prefix = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end <= n; end++) {
                if (prefix[end] - prefix[start] == k) count++;
            }
        }
        return count;
    }
}

//Optimal approach,Time: O(n),Space: O(n)
//using hashmap to store prefix sums and their frequencies
import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // one way to have sum = 0 (empty prefix)

        int count = 0, prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            // Check if prefixSum - k existed before
            if (prefixCount.containsKey(prefixSum - k)) {
                count += prefixCount.get(prefixSum - k);
            }

            // Store current prefixSum in map
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
