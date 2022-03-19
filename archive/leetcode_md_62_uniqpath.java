import java.util.Arrays;
public class leetcode_md_62_uniqpath {

    // 26m
    public int uniquePaths(int m, int n) {
        if(m > n) { // m < n
            int tmp = m;
            m = n;
            n = tmp;
        }

        int[] curr = new int[m];

        Arrays.fill(curr, 1);
        for(int i=1; i<n; ++i){
            for(int j=1; j<m; ++j){
                curr[j] = curr[j] + curr[j-1];
            }
        }

        return curr[m-1];
    }
}
