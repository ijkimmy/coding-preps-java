// import java.util.Arrays;
public class leetcode_md_280_wigglesort {

    // 37m
    public void wiggleSort(int[] nums) {
        // // sort, time: O(nlogn), space: O(n)
        // int[] copy = Arrays.copyOf(nums, nums.length);
        // Arrays.sort(copy);

        // int even = 0, odd = nums.length-1;
        // for(int i=0; i<nums.length; ++i){
        //     nums[i] = i%2==0 ? copy[even++] : copy[odd--];
        // }



        // linear scan, time: O(n), space: O(1)
        for(int i=1; i<nums.length; ++i){
            if((i%2==0 && nums[i-1] < nums[i]) || (i%2==1 && nums[i-1] > nums[i])){
                    int tmp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = tmp;
            }
        }
    }
}
