//Complexity: O(n²) time in worst case (because for each start you may go to end), O(1) extra space.
class solution{
public int maxProductNaive(int[] nums) {
    int n = nums.length;
    int maxProd = nums[0];
    for (int i = 0; i < n; i++) {
        long prod = 1;
        for (int j = i; j < n; j++) {
            prod *= nums[j];
            // cast/check overflow or use long if needed
            if (prod > maxProd) {
                maxProd = (int)prod;
            }
        }
    }
    return maxProd;
}
}

//Complexity: O(n) time, O(1) extra space.
public int maxProduct(int[] nums) {
    int n = nums.length;
    int max= nums[0];
    int min = nums[0];
    int globalMax = nums[0];

    for (int i = 1; i < n; i++) {
        int x = nums[i];
        if (x < 0) {
            // swap because negative will flip max/min
            int temp = max;
            max = min;
            min = temp;
        }
        max = Math.max(x, max * x);
        min = Math.min(x, min * x);
        globalMax = Math.max(globalMax, max);
    }

    return globalMax;
}

//Good when you want a simpler logic than the min/max swap method and you’re okay with scanning twice. Still O(n) time, O(1) space
public int maxProductTwoPass(int[] nums) {
    int n = nums.length;
    int maxProd = Integer.MIN_VALUE;
    long prod = 1;
    // forward
    for (int i = 0; i < n; i++) {
        prod *= nums[i];
        maxProd = (int) Math.max(maxProd, prod);
        if (nums[i] == 0) {
            prod = 1;
        }
    }
    // backward
    prod = 1;
    for (int i = n-1; i >= 0; i--) {
        prod *= nums[i];
        maxProd = (int) Math.max(maxProd, prod);
        if (nums[i] == 0) {
            prod = 1;
        }
    }
    return maxProd;
}
