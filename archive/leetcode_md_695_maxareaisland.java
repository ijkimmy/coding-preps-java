public class leetcode_md_695_maxareaisland {

    // 13m
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0; i<grid.length; ++i){
            for(int j=0; j<grid[0].length; ++j){
                if(grid[i][j] == 1){
                    int area = dfs(i, j, grid);
                    max = max < area ? area : max;
                }
            }
        }

        return max;
    }

    int[] dir = { 0, 1, 0, -1, 0 };
    public int dfs(int r, int c, int[][] grid){
        int area = 0;
        if(0<=r && r<grid.length && 0<=c && c<grid[0].length && grid[r][c] == 1){
            grid[r][c] = 0;
            
            for(int i=0; i+1<dir.length; ++i){
                area += dfs(r+dir[i], c+dir[i+1], grid);
            }

            area += 1;
        }
        return area;
    }
}
