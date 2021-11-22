public class leetcode_md_1706_findball {

    // 51m
    public int[] findBall(int[][] grid) {
        // dfs, time: O(nm), space, O(n)
        int n = grid[0].length;
        int[] retval = new int[n];
        for(int i=0; i<n; ++i){
            retval[i] = traverse(0, i, grid);
        }
        return retval;
    }

    public int traverse(int r, int c, int[][] grid){
        if(r==grid.length) return c;
        
        if(grid[r][c] == 1 && c+1 < grid[0].length && grid[r][c+1] == 1){
            traverse(r+1, c+1, grid);
        }
        else if (grid[r][c] == -1 && c-1 >= 0 && grid[r][c-1] == -1){
            traverse(r+1, c-1, grid);
        }

        return -1;
    }
}
