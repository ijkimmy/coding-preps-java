public class leetcode_ez_977_sortedsquare {
    // 27m
    public int[] sortedSquares(int[] nums) {

        int pos = -1;
        for(int i=0; i<nums.length; ++i){
            if(pos == -1 && nums[i] >= 0) pos = i;
            nums[i] = nums[i] * nums[i];
        }
        
        if(pos == 0) return nums;   // all positive
        if(pos == -1) {     // all negative
            for(int i=0; i<nums.length/2; ++i){
                int tmp = nums[i]; 
                nums[i] = nums[nums.length-1-i]; 
                nums[nums.length-1-i] = tmp;
            }
            return nums;
        }

        int neg = pos-1, idx = 0;
        int[] retval = new int[nums.length];
        while(neg >= 0 && pos < retval.length){
            if(nums[neg] < nums[pos])
                retval[idx++] = nums[neg--];
            else
                retval[idx++] = nums[pos++];
        }

        while(neg >= 0) retval[idx++] = nums[neg--];
        while(pos<retval.length) retval[idx++] = nums[pos++];

        return retval;
    }
}
