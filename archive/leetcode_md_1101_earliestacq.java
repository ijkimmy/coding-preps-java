import java.util.Arrays;
import java.util.Comparator;
public class leetcode_md_1101_earliestacq {

    // 22m
    public int earliestAcq(int[][] logs, int n) {
        // union-find, time: O(nlogn), space: O(n)
        Arrays.sort(logs, new Comparator<>(){
            @Override
            public int compare(int[] l1, int[]l2){
                return l1[0] - l2[0];
            }
        });

        UnionFind uf = new UnionFind(n);
        for(int[] l: logs){
            uf.union(l[1], l[2]);
            if(uf.size == 1){
                return l[0];
            }
        }

        return -1;
    }

    public class UnionFind{
        int[] grp;
        int size;

        public UnionFind(int n){
            grp = new int[n];
            for(int i=0; i<n; ++i){
                grp[i] = i;
            }
            size = n;
        }

        public void union(int a, int b){
            int ua = find(a);
            int ub = find(b);

            if(ua == ub)
                return;
            
            grp[ua] = ub;
            --size;
        }

        public int find(int x){
            if(x == grp[x]){
                return x;
            }
            return grp[x] = find(grp[x]);
        }

        @Override
        public String toString(){
            return Arrays.toString(grp) + "\n" + size;
        }
    }
}
