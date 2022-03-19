import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.HashSet;
public class leetcode_md_721_mergeacc {

    // 60m
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // // union-find, time: O(nklognk), space: O(nk) where k=length of email
        // ufarray = new int[accounts.size()];
        // // size = new int[accounts.size()];
        // for(int i=0; i<ufarray.length; ++i){
        //     ufarray[i] = i;
        //     // size[i] = i;
        // }

        // HashMap<String, Integer> emailtoidx = new HashMap<>();
        // for(int accidx=0; accidx<accounts.size(); ++accidx){
        //     List<String> acc = accounts.get(accidx);
        //     for(int mailidx=1; mailidx<acc.size(); ++mailidx){
        //         String email = acc.get(mailidx);
        //         if(emailtoidx.containsKey(email))
        //             union(emailtoidx.get(email), accidx);
        //         else
        //             emailtoidx.put(email, accidx);
        //     }
        // }

        // HashMap<Integer, List<String>> idxtoemails = new HashMap<>();
        // for(String email: emailtoidx.keySet()){
        //     int idx = find(emailtoidx.get(email));
        //     if(!idxtoemails.containsKey(idx)){
        //         idxtoemails.put(idx, new ArrayList<>());
        //     }
        //     idxtoemails.get(idx).add(email);
        // }

        // List<List<String>> retval = new LinkedList<>();
        // for(int idx: idxtoemails.keySet()){
        //     String name = accounts.get(idx).get(0);
        //     List<String> emails = idxtoemails.get(idx);
            
        //     Collections.sort(emails);
        //     emails.add(0, name);
        //     retval.add(emails);
        // }

        // return retval;



        // DFS, time: O(nklognk), space: O(nk)
        g = new HashMap<>();
        for(int i=0; i<accounts.size(); ++i){
            List<String> acc = accounts.get(i);
            String firstemail = acc.get(1);

            if(!g.containsKey(firstemail)){
                g.put(firstemail, new ArrayList<>());
            }
            
            for(int mailidx = 2; mailidx<acc.size(); ++mailidx){
                String email = acc.get(mailidx);

                g.get(firstemail).add(email);
                
                if(!g.containsKey(email)){
                    g.put(email, new ArrayList<>());
                }
                g.get(email).add(firstemail);
            }
        }

        visited = new HashSet<>();
        List<List<String>> retval = new LinkedList<>();
        for(int i=0; i<accounts.size(); ++i){
            List<String> acc = accounts.get(i);
            String name = acc.get(0), firstemail = acc.get(1);
            if(!visited.contains(firstemail)){
                List<String> mergedlst = new ArrayList<>();
                DFS(mergedlst, firstemail);
                Collections.sort(mergedlst);
                mergedlst.add(0, name);
                
                retval.add(mergedlst);
            }
        }

        return retval;
    }

    HashMap<String, List<String>> g;
    HashSet<String> visited;

    public void DFS(List<String> lst, String email){
        lst.add(email);
        visited.add(email);

        // if(!g.containsKey(email))
        //     return;

        for(String adj: g.get(email)){
            if(!visited.contains(adj)){
                DFS(lst, adj);
            }
        }
    }

    // ///////////////////////////////////////////////////////////
    // // union-find
    // ///////////////////////////////////////////////////////////
    // int[] ufarray;
    // // int[] size; // for union-by-size implm.

    // public void union(int x, int y){
    //     int xidx = find(x);
    //     int yidx = find(y);

    //     ufarray[xidx] = yidx;

    //     // if(xidx == yidx) return;

    //     // if(size[xidx] >= size[yidx]){
    //     //     size[xidx] += size[yidx];
    //     //     ufarray[yidx] = xidx;
    //     // } else {
    //     //     size[yidx] += size[xidx];
    //     //     ufarray[xidx] = yidx;
    //     // }
    // }

    // public int find(int x){
    //     if(ufarray[x] == x){
    //         return x;
    //     }

    //     return ufarray[x] = find(ufarray[x]);
    // }
}
