// import java.util.Arrays;
public class leetcode_md_64_minpathsum {

    // 44m
    public int minPathSum(int[][] grid) {
        // // recursive dfs, time: O(nm), space: O(nm)
        // int[][] memo = new int[grid.length][grid[0].length];
        // for(int[] arr: memo)
        //     Arrays.fill(arr, -1);
        // return dfs(0, 0, memo, grid);



        // iterative with opt space, time: O(mn), space: O(1)
        int n = grid.length, m = grid[0].length;
        for(int r=n-1; r>=0; --r){
            for(int c=m-1; c>=0; --c){
                if(r+1 < n && c+1 < m)
                    grid[r][c] += Math.min(grid[r+1][c], grid[r][c+1]);
                else if(r+1 < n)
                    grid[r][c] += grid[r+1][c];
                else if(c+1 < m)
                    grid[r][c] += grid[r][c+1];
            }
        }
        return grid[0][0];
    }

    public int dfs(int r, int c, int[][] memo, int[][] grid){
        if(r == grid.length-1 && c == grid[r].length-1) return grid[r][c];
        if(memo[r][c] != -1) return memo[r][c];

        int path = Integer.MAX_VALUE;
        if(r+1 < grid.length)
            path = dfs(r+1, c, memo, grid);
        if(c+1 < grid[r].length)
            path = Math.min(dfs(r, c+1, memo, grid), path);
        memo[r][c] = path + grid[r][c];

        return memo[r][c];
    }
}
