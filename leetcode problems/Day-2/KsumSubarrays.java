//Brute force approach,Time: O(n³),Space: O(1)
//not optimal beecause it re-sum all elements — too slow for large inputs
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
