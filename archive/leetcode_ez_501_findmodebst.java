/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// import java.util.HashMap;
// import java.util.Queue;
import java.util.LinkedList;
public class leetcode_ez_501_findmodebst {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // 43m
    public int[] findMode(TreeNode root) {
        // // hashmap solution, 
        // HashMap<Integer, Integer> cnt = new HashMap<>();

        // Queue<TreeNode> q = new LinkedList<>();
        // q.offer(root);
        // int maxcnt = 0, nummodes = 0;
        // while(!q.isEmpty()){
        //     TreeNode node = q.poll();

        //     int newcnt = cnt.getOrDefault(node.val, 0) + 1;
        //     if(newcnt > maxcnt){
        //         maxcnt = newcnt;
        //         nummodes = 1;
        //     }
        //     else if(newcnt == maxcnt)
        //         ++nummodes;

        //     cnt.put(node.val, newcnt);

        //     if(node.left != null) q.offer(node.left);
        //     if(node.right != null) q.offer(node.right);
        // }

        // int arridx = 0;
        // int[] retval = new int[nummodes];
        // for(int key: cnt.keySet()){
        //     if(cnt.get(key) == maxcnt)
        //         retval[arridx++] = key;
        // }

        // return retval;


        // optimal solution using inorder traversal
        // although it has same complexity, both in time and space wise much efficient by constant
        LinkedList<Integer> lst = new LinkedList<>();
        inorder(root, lst);
        int[] retval = new int[lst.size()];
        for(int i=0; i<retval.length; ++i) 
            retval[i] = lst.get(i);
        return retval;
    }

    Integer prev = null;
    int currcnt = 0, maxcnt = 0;

    public void inorder(TreeNode root, LinkedList<Integer> retval){
        if(root == null) return;

        inorder(root.left, retval);
        if(prev == null) prev = root.val;

        if(prev == root.val){
            ++currcnt;
            if(currcnt > maxcnt){
                maxcnt = currcnt;
                retval.clear();
            }
        }
        else{
            prev = root.val;
            currcnt = 1;
        }

        if(currcnt == maxcnt)
            retval.add(root.val);

        inorder(root.right, retval);
    }
}
