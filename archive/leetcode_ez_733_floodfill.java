public class leetcode_ez_733_floodfill {

    // 19m
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor)
            dfs(sr, sc, image, image[sr][sc], newColor);
        return image;
    }

    public void dfs(int r, int c, int[][] image, int orgColor, int newColor){
        if(0<=r && r<image.length && 0<=c && c<image[0].length && image[r][c]==orgColor){
            image[r][c] = newColor;

            dfs(r-1, c, image, orgColor, newColor);
            dfs(r+1, c, image, orgColor, newColor);
            dfs(r, c-1, image, orgColor, newColor);
            dfs(r, c+1, image, orgColor, newColor);
        }
    }
}
