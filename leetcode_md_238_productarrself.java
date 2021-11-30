public class leetcode_md_238_productarrself {

    // 15m
    public int[] productExceptSelf(int[] nums) {
        // time: O(n), space: O(1)
        int n = nums.length;
        int[] retval = new int[n];

        int product = 1;
        for(int i=0; i<n-1; ++i){
            product *= nums[i];
            retval[i+1] = product;
        }

        product = 1;
        retval[0] = 1;
        for(int i=n-1; i>0; --i){
            product *= nums[i];
            retval[i-1] *= product;
        }

        return retval;
    }
}
