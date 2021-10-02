public class leetcode_ez_268_missingnum {

    // 12m
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n * n+1) / 2;
        for(int num: nums)
            sum -= num;
        return sum;
    }
}
