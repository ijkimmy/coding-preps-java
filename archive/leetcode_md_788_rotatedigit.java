import java.util.Set;
import java.util.HashSet;
public class leetcode_md_788_rotatedigit {

    // 106m
    public int rotatedDigits(int n) {
        // // brute force, time: O(nlogn), space: O(1)
        // int cnt = 0;
        // for(int i=1; i<=n; ++i){
        //     if(check(i))
        //         ++cnt;
        // }

        // return cnt;



        // // dynamic programming, time: O(n), space: O(n)
        // int cnt = 0;
        // int[] dp = new int[n+1];
        // for(int i=0; i<=n; ++i){
        //     if(i<10){
        //         switch(i){
        //             case 0: case 1: case 8:
        //                 dp[i] = 1; break;
        //             case 2: case 5: case 6: case 9:
        //                 dp[i] = 2; ++cnt; break;
        //             default:
        //         }
        //     } else if(dp[i/10] != 0){
        //         if(dp[i/10] == 1 && dp[i%10] == 1) dp[i] = 1;
        //         else if(dp[i/10] >= 1 && dp[i%10] >= 1) {
        //             dp[i] = 2;
        //             ++cnt;
        //         }
        //     }
        // }

        // return cnt;



        // permutation, time: O(logn), space: O(1)
        Set<Integer> unchanged = Set.of(0, 1, 8);
        Set<Integer> all = Set.of(0, 1, 2, 5, 6, 8, 9);
        Set<Integer> prev = new HashSet<>();

        int cnt = 0;
        char[] num = String.valueOf(n).toCharArray();        
        int po7 = (int)Math.pow(7, num.length-1), po3 = (int)Math.pow(3, num.length-1);
        for(int i=0; i<num.length; ++i, po7 /= 7, po3 /= 3){
            int curr = num[i] - '0';
            for(int j=0; j<curr; ++j){
                if(all.contains(j))
                    cnt += po7;
                if(unchanged.containsAll(prev) && unchanged.contains(j))
                    cnt -= po3;
            }
            prev.add(curr);
            if(!all.contains(curr))
                return cnt;
        }

        return cnt + (unchanged.containsAll(prev) ? 0 : 1);
    }

    public boolean check(int i){
        Set<Integer> same = Set.of(0, 1, 8);
        Set<Integer> diff = Set.of(2, 5, 6, 9);

        boolean hasdiff = false;
        while(i > 0){
            int r = i%10; 
            if(diff.contains(r)) hasdiff = true;
            if(!same.contains(r) && !diff.contains(r)) return false;
            i /= 10;
        }

        return hasdiff;
    }
}
