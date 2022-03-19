/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

import java.util.HashSet;
public class leetcode_md_1650_lowestcommancestor {
    class Node{
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }


    // 29m
    public Node lowestCommonAncestor(Node p, Node q) {
        // // much simpler solution
        // Node a = p, b = q;
        // while(a!=b){
        //     a = a==null? q : a.parent;
        //     b = b==null? p : b.parent;
        // }
        // return a;

        if(p==null||q==null||p==q) return p;

        HashSet<Integer> visited = new HashSet<>();
        while(p != null){
            if(dfs(p, q.val, visited)) return p;

            p = p.parent;
        }

        return p;
    }

    public boolean dfs(Node root, int val, HashSet<Integer> visited){
        if(root == null || visited.contains(root.val)) return false;
        if(root.val == val) return true;

        visited.add(root.val);
        return dfs(root.left, val, visited) || dfs(root.right, val, visited);
    }
}
