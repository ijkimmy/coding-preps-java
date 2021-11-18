import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
public class leetcode_md_399_evaluatediv {

    // 110m
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // // DFS-graph, time: O(q*eq), space: O(eq+q) including returning val
        // HashMap<String, HashMap<String, Double>> g = new HashMap<>();
        // for(int i=0; i<equations.size(); ++i){
        //     List<String> eq = equations.get(i);
        //     String nom = eq.get(0), denom = eq.get(1);
            
        //     if(!g.containsKey(nom))
        //         g.put(nom, new HashMap<>());
        //     g.get(nom).put(denom, values[i]);
        //     if(!g.containsKey(denom))
        //         g.put(denom, new HashMap<>());
        //     g.get(denom).put(nom, 1/values[i]);
        // }

        // double[] retval = new double[queries.size()];
        // for(int i=0; i<queries.size(); ++i){
        //     List<String> q = queries.get(i);
        //     String nom = q.get(0), denom = q.get(1);

        //     if(!g.containsKey(nom) || !g.containsKey(denom)){
        //         retval[i] = -1;
        //     } else if(nom.equals(denom)){
        //         retval[i] = 1;
        //     } else {
        //         retval[i] = dfs(g, new HashSet<String>(), 1, nom, denom);
        //     }
        // }

        // return retval;




        // union-find w weights, time: O((q+eq)logeq), space: O(eq)
        HashMap<String, Pair> map = new HashMap<>();

        for(int i=0; i<equations.size(); ++i){
            List<String> eq = equations.get(i);
            String num = eq.get(0), denom = eq.get(1);
            
            union(map, num, denom, values[i]);
        }

        double[] retval = new double[queries.size()];
        for(int i=0; i<queries.size(); ++i){
            List<String> q = queries.get(i);
            String num = q.get(0), denom = q.get(1);

            if(!map.containsKey(num) || !map.containsKey(denom)){
                retval[i] = -1;
            } else {
                Pair numpair = find(map, num);
                Pair denpair = find(map, denom);

                if(numpair.key.equals(denpair.key))
                    retval[i] = 1;
                else 
                    retval[i] = numpair.val / denpair.val;
            }
        }

        return retval;
    }

    public void union(HashMap<String, Pair> map, String num, String denom, double val){
        Pair nump = find(map, num);
        Pair denp = find(map, denom);

        // merge two groups
        if(!nump.key.equals(denp.key)){
            map.put(nump.key, new Pair(denp.key, val * denp.val / nump.val));
        }
    }

    public Pair find(HashMap<String, Pair> map, String key){
        if(!map.containsKey(key)) 
            map.put(key, new Pair(key, 1));
        
        Pair oldp = map.get(key);
        if(!oldp.key.equals(key)){
            Pair newp = find(map, oldp.key);
            map.put(key, new Pair(newp.key, oldp.val * newp.val));
        }
        
        return map.get(key);
    }

    public class Pair{
        String key;
        double val;

        public Pair(String key, double val) { this.key = key; this.val = val; }
    }

    public double dfs(HashMap<String, HashMap<String, Double>> g, HashSet<String> visited, double val, String curr, String targ){
        visited.add(curr);
        HashMap<String, Double> adj = g.get(curr);
        if(adj.containsKey(targ))
            return val * adj.get(targ);
        
        for(String key: adj.keySet()){
            if(visited.contains(key))
                continue;
            double retval = dfs(g, visited, val*adj.get(key), key, targ);
            if(retval != -1)
                return retval;
        }
        visited.remove(curr);

        return -1;
    }
}
