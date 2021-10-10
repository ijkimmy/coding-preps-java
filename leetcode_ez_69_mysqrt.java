public class leetcode_ez_69_mysqrt {

    // 38m
    public int mySqrt(int x) {
        if(x < 2) return x;

        int lo = 0, hi = x/2;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if((x/mid) == mid) return mid;
            else if((x/mid) < mid) hi = mid-1;
            else lo = mid+1;
        }
        return hi;
    }
}
