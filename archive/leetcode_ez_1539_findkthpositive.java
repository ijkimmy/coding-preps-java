public class leetcode_ez_1539_findkthpositive {
    
    // 19m
    public int findKthPositive(int[] arr, int k) {
        // // linear solution
        // int missing = 0, arridx = 0;
        // for(int i=1; i<arr.length+k+1; ++i){
        //     if(arridx<arr.length && i == arr[arridx])
        //         ++arridx;
        //     else if(++missing == k)
        //         return i;
        // }
        // return -1;


        // logarithmic solution
        int left = 0, right = arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]-mid-1 < k) left = mid - 1;
            else right = mid + 1;
        }
        return left+k;
    }
}
