//Brute-force Approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}

//Optimized Approach- One-pass HashMap
import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}

//Optimized Approach- Sorting + Two-pointer (when you only need values not original indices)
import java.util.Arrays;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] copy=Arrays.copyOf(nums,nums.length);
        Arrays.sort(copy);
        int left=0;
        int right=copy.length-1;
        while(left<right){
            int sum=copy[left]+copy[right];
            if(sum==target){
                return new int[]{copy[left],copy[right]};
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{};
    }
}