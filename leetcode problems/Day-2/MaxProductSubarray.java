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

