public class leetcode_md_875_mineatingspeed {

    // 22m
    public int minEatingSpeed(int[] piles, int h) {
        // binary search, time: O(nlog(max(p))), space: O(1)
        int min = 1, max = 0;
        for(int p: piles){
            max = Math.max(p, max);
        }

        if(piles.length == h)
            return max;

        while(min < max){
            int eat = min + (max - min)/2;

            int tothr = 0;
            for(int p: piles){
                tothr += p/eat;
                tothr += p%eat==0 ? 0 : 1;
            }

            if(tothr <= h){
                max = eat;
            } else {
                min = eat+1;
            }
        }

        return min;
    }
}
