/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class leetcode_ez_374_guessgame {
    int guess(int num) { return -1; }

    // 8m
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            
            int ans = guess(mid);
            if(ans == 0) return mid;
            else if(ans < 0) hi = mid-1;
            else lo = mid+1;
        }

        return lo;
    }
}
