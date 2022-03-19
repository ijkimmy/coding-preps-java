public class leetcode_md_287_finddup {

    // 40m
    public int findDuplicate(int[] nums) {
        // // negative marking, time: O(n), space: O(1)
        // // BUT it makes changes to array!
        // for(int i=0; i<nums.length; ++i){
        //     int idx = Math.abs(nums[i]);            
        //     nums[idx] = -nums[idx];
        //     if(nums[idx] > 0) return nums[idx];
        // }
        // return 0;



        // // array as hashmap, time: O(n), space: O(1)
        // // BUT it makes changes to array!
        // while(nums[nums[0]] != nums[0]){
        //     int tmp = nums[nums[0]];
        //     nums[nums[0]] = nums[0];
        //     nums[0] = tmp;
        // }

        // return nums[0];



        // // binary search, time: O(nlogn), space: O(1)
        // int lo = 1, hi = nums.length-1, dup = 0;
        // while(lo <= hi){
        //     int mid = lo + (hi-lo)/2, cnt = 0;
        //     for(int n: nums)
        //         if(n < mid)
        //             ++cnt;
        //     if(cnt > mid){
        //         dup = mid;
        //         hi = mid-1;
        //     } else
        //         lo = mid+1;
        // }

        // return dup;



        // Floyd LinkedList cycle detection alg., time: O(n), space: O(1)
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while(slow != fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        
        return slow;
    }
}
