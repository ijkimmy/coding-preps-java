public class leetcode_ez_1929_concatarray {
    // 4m
    public int[] getConcatenation(int[] nums) {
        int[] retval = new int[nums.length * 2];
        for(int i=0; i<nums.length; ++i){
            retval[i] = nums[i];
            retval[i+nums.length] = nums[i];
        }
        return retval;
    }
}
