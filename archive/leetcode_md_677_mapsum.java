import java.util.HashMap;
// import java.util.Queue;
// import java.util.LinkedList;
public class leetcode_md_677_mapsum {
    class Trie{
        HashMap<Character, Trie> next;
        int val;

        public Trie(){
            next = new HashMap<>();
            val = 0;
        }

        @Override
        public String toString(){
            return next.toString() + ", val: " + val;
        }
    }

    Trie root;
    HashMap<String, Integer> score;
    

    // 33m
    public leetcode_md_677_mapsum() {
        root = new Trie();
        score = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int delt = val - score.getOrDefault(key, 0);
        score.put(key, val);
        root.val += delt;

        Trie node = root;
        for(int i=0; i<key.length(); ++i){
            char c = key.charAt(i);
            if(!node.next.containsKey(c)){
                node.next.put(c, new Trie());
            }
            node = node.next.get(c);
            node.val += delt;
        }
    }
    
    public int sum(String prefix) {
        Trie node = root;
        for(int i=0; i<prefix.length(); ++i){
            char c = prefix.charAt(i);
            if(!node.next.containsKey(c)){
                return 0;
            }
            node = node.next.get(c);
        }

        return node.val;

        // Queue<Trie> q = new LinkedList<>();
        // q.offer(node);

        // int val = 0;
        // while(!q.isEmpty()){
        //     Trie curr = q.poll();
        //     val += curr.val;
            
        //     for(char key: curr.next.keySet()){
        //         q.offer(curr.next.get(key));
        //     }
        // }

        // return val;
    }
}
