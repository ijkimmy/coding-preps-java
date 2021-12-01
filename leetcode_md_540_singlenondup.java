public class leetcode_md_540_singlenondup {

    // 15m
    public int singleNonDuplicate(int[] nums) {
        // binary search, time: O(log n), space; O(1)
        int l = 0, r = nums.length-1;
        while(l < r){
            int mid = l + (r-l)/2;

            int first = mid-1, second = mid;
            if(first < 0 || nums[first] != nums[second]){
                first = mid;
                second = mid+1;
            }

            if(nums[first] != nums[second]){
                return nums[mid];
            } 
            
            if(second%2 == 0){
                r = first-1;
            } else {
                l = second+1;
            }
        }

        return nums[l];
    }
}
