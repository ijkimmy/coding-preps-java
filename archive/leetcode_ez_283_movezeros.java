public class leetcode_ez_283_movezeros {

    // 20m
    public void moveZeroes(int[] nums) {
        // // sub optimal solution
        // int left = 0;
        // for(int i=0; i<nums.length; ++i){
        //     if(nums[i]!=0)
        //         nums[left++] = nums[i];            
        // }

        // for(; left<nums.length; ++left)
        //     nums[left] = 0;

        // optimal solution
        int left = 0;
        for(int i=0; i<nums.length; ++i){
            if(nums[i] != 0){
                if(i==left) { left++; continue; }
                nums[left++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
