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

//optimal approach-O(n) time complexity and O(1) space complexity
//Optimal = Two Pointers → O(n)
import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int ind = 1; // index for unique elements

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) // if not a duplicate
            {
                nums[ind] = nums[i];// place the unique element at the 'ind' index
                ind++;// increment the index for next unique element
            }
        }

        System.out.println(Arrays.toString(Arrays.copyOf(nums, ind)));// Arrays.copyOf(nums, ind)- creates a new array containing the first 'ind' elements of 'nums', which are the unique elements after removing duplicates.
        return ind;// return the count of unique elements
    }
}


//using arrays stream-O(n) time complexity and O(n) space complexity
//not recommended because it creates an additional array,collections,objects which uses extra memory
import java.util.*;
import java.util.stream.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        int[] unique = Arrays.stream(nums).distinct().toArray();// Get unique elements using stream,
        //distinct() method is used to filter out duplicate elements from the stream.
        //toArray() method converts the stream back into an array.

        for (int i = 0; i < unique.length; i++) {
            nums[i] = unique[i];// Copy unique elements back to original array
        }

        return unique.length;   // Return the count of unique elements
    }
}

//using hashset-O(n) time complexity and O(n) space complexity
//-not recommended for large arrays due to extra space usage
import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int i = 0;
        for (int num : set) {
            nums[i++] = num;
        }

        return i;
    }
}
