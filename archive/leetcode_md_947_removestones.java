import java.util.HashMap;
public class leetcode_md_947_removestones {

    // 56m
    public int removeStones(int[][] stones) {
        // union-find, time: O(n), space: O(n)
        final int maxcoord = 10001;

        UnionFind uf = new UnionFind();
        for(int i=0; i<stones.length; ++i){
            uf.union(stones[i][0], maxcoord+stones[i][1]);
        }

        return uf.cnt;
    }

    class UnionFind{
        HashMap<Integer, Integer> grp;
        int cnt;

        public UnionFind(){
            grp = new HashMap<>();
            cnt = 0;
        }

        public void union(int x, int y){
            int grpx = find(x);
            int grpy = find(y);

            if(grpx == grpy)
                return;
            
            grp.put(grpx, grpy);
            --cnt;
        }

        public int find(int x){
            if(!grp.containsKey(x)){
                grp.put(x, x);
                ++cnt;
            }

            if(x != grp.get(x)){
                grp.put(x, find(grp.get(x)));
            }

            return grp.get(x);
        }

        @Override
        public String toString(){
            return grp.toString() + ", cnt: " + cnt;
        }
    }
}
