import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
public class matchhere_day24_q2 {
    public static void main(String[] args){
        // BJ 17472
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][m];
            for(int i=0; i<n; ++i){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; ++j){
                    int val = Integer.parseInt(st.nextToken());
                    map[i][j] = -val;
                }
            }

            int numisland = 0;
            for(int i=0; i<n; ++i)
                for(int j=0; j<m; ++j){
                    if(map[i][j] == -1){
                        dfs(map, i, j, ++numisland);
                    }
                }
            
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]);
            addBridge(map, pq);

            int blen = 0;
            UnionFind uf = new UnionFind(numisland+1);
            while(!pq.isEmpty() && uf.numisland < numisland-1){
                int[] bridge = pq.poll();

                if(bridge[2] < 2)
                    continue;
                
                if(uf.union(bridge[0], bridge[1]))
                    blen += bridge[2];
            }

            System.out.print(uf.numisland==numisland-1 ? blen : -1);
        } catch(IOException e){
            System.out.print(e);
        }
    }

    static void addBridge(int[][] map, PriorityQueue<int[]> pq){
        int n = map.length, m = map[0].length;
        for(int i=0; i<n; ++i){
            int previd = -1, count0s = 0;
            for(int j=0; j<m; ++j){
                if(map[i][j] == 0){
                    if(previd != -1)
                        ++count0s;
                    continue;
                } 

                if(previd != -1 && previd != map[i][j]){
                    pq.offer(new int[] { previd, map[i][j], count0s });
                }
                previd = map[i][j];
                count0s = 0;
            }
        }

        for(int j=0; j<m; ++j){
            int previd = -1, count0s = 0;
            for(int i=0; i<n; ++i){
                if(map[i][j] == 0){
                    if(previd != -1)
                        ++count0s;
                    continue;
                } 

                if(previd != -1 && previd != map[i][j]){
                    pq.offer(new int[] { previd, map[i][j], count0s });
                }
                previd = map[i][j];
                count0s = 0;
            }
        }
    }

    static int[] dir = { 1, 0, -1, 0, 1 };
    static void dfs(int[][] map, int r, int c, int id){
        if(0<=r && r<map.length && 0<=c && c<map[r].length && map[r][c] == -1){
            map[r][c] = id;
            for(int i=0; i<dir.length-1; ++i){
                int nextr = r+dir[i], nextc = c+dir[i+1];
                dfs(map, nextr, nextc, id);
            }
        }
    }

    static class UnionFind{
        int[] islands;
        int numisland;

        public UnionFind(int n){
            islands = new int[n];
            for(int i=0; i<n; ++i)
                islands[i] = i;
        }

        public boolean union(int x, int y){
            int fx = find(x);
            int fy = find(y);

            if(fx == fy)
                return false;
            
            islands[fx] = fy;
            ++numisland;
            return true;
        }

        public int find(int x){
            if(x != islands[x]){
                islands[x] = find(islands[x]);
            }
            return islands[x];
        }
    }
}
