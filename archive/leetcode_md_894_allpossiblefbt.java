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

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
public class leetcode_md_894_allpossiblefbt {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 29m
    HashMap<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(!map.containsKey(n)){
            List<TreeNode> retval = new LinkedList<>();
            if(n==0 || n%2==0) return retval;
            if(n==1) 
                retval.add(new TreeNode(0));
    
            for(int i=1; i<n-1; i+=2){
                // List<TreeNode> leftsub = allPossibleFBT(i);
                // List<TreeNode> rightsub = allPossibleFBT(n-i-1);
                for(TreeNode left: allPossibleFBT(i)){
                    for(TreeNode right: allPossibleFBT(n-i-1)){
                        TreeNode root = new TreeNode(0, left, right);
                        retval.add(root);
                    }
                }
            }

            map.put(n, retval);
        }

        return map.get(n);
    }
}
