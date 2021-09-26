public class leetcode_ez_905_sortarrbyparity {
    // 20m
    public int[] sortArrayByParity(int[] nums) {
        // // 2 pointer method
        // int oddpt = 0, evenpt = nums.length-1;
        // while(oddpt<nums.length && nums[oddpt]%2==0) ++oddpt;
        // while(0<=evenpt && nums[evenpt]%2==1) --evenpt;

        // while(oddpt < evenpt){
        //     int tmp = nums[oddpt];
        //     nums[oddpt] = nums[evenpt];
        //     nums[evenpt] = tmp;

        //     while(nums[oddpt]%2==0) ++oddpt;
        //     while(nums[evenpt]%2==1) --evenpt;
        // }

        // return nums;

        // 1 pointer method
        int even = 0;
        for(int i=0; i<nums.length; ++i){
            if(nums[i]%2==0){
                int tmp = nums[i];
                nums[i] = nums[even];
                nums[even++] = tmp;                
            }
        }
        return nums;
    }
}
