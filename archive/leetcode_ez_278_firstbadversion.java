/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class leetcode_ez_278_firstbadversion {
    boolean isBadVersion(int version) { return true; }

    // 5m
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(isBadVersion(mid)) hi = mid;
            else lo = mid+1;
        }

        return lo;
    }
}
