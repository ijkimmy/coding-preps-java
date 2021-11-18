public class leetcode_md_208_trie {
    public class Node{
        Node[] next = new Node[26];
        boolean isend = false;
    }

    Node root;

    // 16m
    public leetcode_md_208_trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node pt = root;

        for(int i=0; i<word.length(); ++i){
            int curr = word.charAt(i)-'a';
            if(pt.next[curr] == null) pt.next[curr] = new Node();
            pt = pt.next[curr];
        }
        pt.isend = true;
    }
    
    public boolean search(String word) {
        Node pt = getNode(word);
        if(pt == null || pt.isend == false) return false;
        return true;
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    public Node getNode(String word){
        Node pt = root;
        for(int i=0; i<word.length(); ++i){
            int curr = word.charAt(i)-'a';
            if(pt.next[curr] == null) return null;
            pt = pt.next[curr];
        }
        return pt;
    }
}
