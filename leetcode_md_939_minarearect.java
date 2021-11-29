import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class leetcode_md_939_minarearect {
    class Tuple{
        int y1;
        int y2;
        
        public Tuple(int y1, int y2) { this.y1 = y1; this.y2 = y2; }
        
        @Override
        public boolean equals(Object y){
            if(this == y) return true;
            if(!(y instanceof Tuple)) return false;
            Tuple tuple = (Tuple) y;
            return this.y1 == tuple.y1 && this.y2 == tuple.y2;
        }

        @Override
        public int hashCode(){
            int hash = 5;
            hash = 7*hash + Integer.hashCode(y1);
            hash = 7*hash + Integer.hashCode(y2);
            return hash;
        }

        @Override
        public String toString(){
            return "y1: " + y1 + ", y2: " + y2;
        }
    }


    // 70m
    public int minAreaRect(int[][] points) {
        TreeMap<Integer, List<Integer>> pts = new TreeMap<>();

        for(int[] pt: points){
            if(!pts.containsKey(pt[0]))
                pts.put(pt[0], new ArrayList<>());
            pts.get(pt[0]).add(pt[1]);
        }

        int minarea = Integer.MAX_VALUE;
        HashMap<Tuple, Integer> prevs = new HashMap<>();
        for(int x: pts.keySet()){
            List<Integer> ys = pts.get(x);

            if(ys.size() < 2)
                continue;
            
            Collections.sort(ys);
            for(int i=0; i<ys.size(); ++i){
                for(int j=i+1; j<ys.size(); ++j){
                    int y1 = ys.get(i), y2 = ys.get(j);
                    Tuple t = new Tuple(y1, y2);
                    if(prevs.containsKey(t)){
                        minarea = Math.min(minarea, (y2-y1) * (x - prevs.get(t)));
                    }
                    prevs.put(t, x);
                }
            }
        }

        return (minarea==Integer.MAX_VALUE) ? 0 : minarea;
    }
}
