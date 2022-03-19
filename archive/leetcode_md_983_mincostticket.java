import java.util.Arrays;
public class leetcode_md_983_mincostticket {

    // 38m
    public int mincostTickets(int[] days, int[] costs) {
        return dp(days, costs, new int[] { 1, 7, 30 }, 0, new int[days.length]);
    }

    public int dp(int[] days, int[] costs, int[] pass, int day, int[] memo){
        if(day == days.length-1){
            int min = Math.min(costs[0], costs[1]);
            return Math.min(min, costs[2]);
        } 
        else if (day >= days.length) return 0;

        if(memo[day] != 0) return memo[day];

        int min = Integer.MAX_VALUE;
        for(int i=0; i<costs.length; ++i){
            int nextday = days[day] + pass[i];
            int nextidx = Arrays.binarySearch(days, nextday);
            if(nextidx < 0) nextidx = -nextidx - 1;
            min = Math.min(min, costs[i] + dp(days, costs, pass, nextidx, memo));
        }
        memo[day] = min;

        return memo[day];
    }
}
