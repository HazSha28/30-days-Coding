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
