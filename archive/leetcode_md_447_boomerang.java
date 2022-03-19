import java.util.HashMap;
public class leetcode_md_447_boomerang {

    // 37m
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length, retval = 0;
        for(int i=0; i<n; ++i){
            HashMap<Integer, Integer> distcnt = new HashMap<>();
            for(int j=0; j<n; ++j){
                if(i==j) continue;

                int[] p1 = points[i];
                int[] p2 = points[j];

                int dx = p2[0]-p1[0], dy = (p2[1]-p1[1]);
                int d = dx*dx + dy*dy;
                distcnt.put(d, distcnt.getOrDefault(d, 0)+1);
            }

            for(int d: distcnt.keySet()){
                int cnt = distcnt.get(d);
                retval += (cnt-1) * cnt;
            }
        }

        return retval;
    }
}
