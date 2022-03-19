// import java.util.HashMap;
public class leetcode_ez_169_majorityelement {

    // 26m
    public int majorityElement(int[] nums) {
        // // Brute Force solution
        // int maxcnt=0, retval=-1;
        // HashMap<Integer, Integer> cntnums = new HashMap<>();
        // for(int num: nums){
        //     int cnt = cntnums.getOrDefault(num, 0)+1;
        //     cntnums.put(num, cnt);

        //     if(cnt > maxcnt){
        //         maxcnt = cnt;
        //         retval = num;
        //     }
        // }
        // return retval;

        // Boyer-Moore Voting Algorithm
        // uses the fact that majority number appears at least once in every pair
        int num = 0, cnt = 0;
        for(int n: nums){
            if(cnt==0)
                num = n;
            cnt += (num==n) ? 1 : -1;
        }
        return num;
    }
}
