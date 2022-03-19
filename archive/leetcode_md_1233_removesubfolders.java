import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
// import java.util.HashSet;
public class leetcode_md_1233_removesubfolders {

    // 100m
    public List<String> removeSubfolders(String[] folder) {
        // // Trie, time: O(nm), space: O(nm)
        // Trie root = new Trie();

        // for(int i=0; i<folder.length; ++i){
        //     String[] fs = folder[i].split("/");
        //     Trie node = root;
        //     for(int j=1; j<fs.length; ++j){
        //         if(!node.sub.containsKey(fs[j])) node.sub.put(fs[j], new Trie());
        //         node = node.sub.get(fs[j]);
        //         if(node.index == -1) break;
        //     }
        //     node.index = node.index == -1 ? i : node.index;
        //     node.sub = null;
        // }

        // return bfs(root, folder);



        // // sort folder by length, time: O(nlogn + m^2n), space: O(nm)
        // Arrays.sort(folder, (a,b)->a.length()-b.length());
        // HashSet<String> seen = new HashSet<>();
        // outer:
        // for(String str: folder){
        //     for(int i=2; i<str.length(); ++i){
        //         if(str.charAt(i) == '/' && seen.contains(str.substring(0, i)))
        //             continue outer;
        //     }
        //     seen.add(str);
        // }
        // return new LinkedList<>(seen);



        // sort array alphabetically, time: O(nlogn + nm), space: O(log n) < for sorting
        Arrays.sort(folder);
        
        LinkedList<String> retval = new LinkedList<>();
        for(String str: folder){
            if(retval.isEmpty() || !str.startsWith(retval.peekLast() + "/"))
                retval.offer(str);
        }
        return retval;
    }

    class Trie{
        HashMap<String, Trie> sub = new HashMap<>();
        int index = -1;
    }

    public List<String> bfs(Trie node, String[] folder){
        List<String> retval = new LinkedList<>();
        Queue<Trie> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            Trie t = q.poll();
            if(t.index != -1){
                retval.add(folder[t.index]);
                continue;
            }

            for(String key: t.sub.keySet()){
                q.offer(t.sub.get(key));
            }
        }

        return retval;
    }
}
