import java.util.Queue;
import java.util.LinkedList;
public class leetcode_md_1765_highestpeak {

    // 87m
    public int[][] highestPeak(int[][] isWater) {
        // bfs, time: O(mn), space: O(mn)
        int[][] retval = new int[isWater.length][isWater[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<isWater.length; ++i)
            for(int j=0; j<isWater[i].length; ++j){
                if(isWater[i][j] == 1)
                    q.offer(new int[] { i, j });
                else
                    retval[i][j] = -1;
            }
                
        int[] dir = { 0, 1, 0, -1, 0 };
        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int d=0; d<dir.length-1; ++d){
                int nr = curr[0] + dir[d];
                int nc = curr[1] + dir[d+1];
                if(0<=nr && nr<isWater.length && 0<=nc && nc<isWater[nr].length && retval[nr][nc] == -1) {
                    retval[nr][nc] = retval[curr[0]][curr[1]] + 1;
                    q.offer(new int[] { nr, nc });
                }
            }
        }

        return retval;
    }
}
