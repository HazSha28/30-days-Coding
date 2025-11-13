//time complexity: O(n^2)
//space complexity: O(1)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum % k == 0) return true;
            }
        }
        return false;
    }
}

//time complexity: O(n^2)
//space complexity: O(n)
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j <= n; j++) { 
                if ((prefix[j] - prefix[i]) % k == 0)
                    return true;
            }
        }

        return false;
    }


//time complexity: O(n)
//space complexity: O(n)
    public boolean checkSubarrSum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // to handle the case when the subarray starts from index 0
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }

