public class leetcode_md_1254_closedisland {

    // 19m
    public int closedIsland(int[][] grid) {
        int island = 0;
        for(int i=0; i<grid.length; ++i)
            for(int j=0; j<grid[i].length; ++j)
                if(grid[i][j] == 0 && dfs(i, j, grid))
                    ++island;
        return island;
    }

    int[] dir = { 0, 1, 0, -1, 0 };
    public boolean dfs(int r, int c, int[][] grid){
        if(0<=r && r<grid.length && 0<=c && c<grid[0].length){
            boolean result = true;
            if(grid[r][c] == 0){
                grid[r][c] = -1;
                for(int i=0; i<dir.length-1; ++i)
                    if(!dfs(r+dir[i], c+dir[i+1], grid))
                        result = false;
            }

            return result;
        }

        return false;
    }
}
