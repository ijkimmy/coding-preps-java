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
public class leetcode_ez_257_binarytreepaths {
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

    // 26m
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> lst = new LinkedList<>();
        if(root == null) return lst;

        dfs(root, lst, new StringBuilder());
        return lst;
    }

    public void dfs(TreeNode root, List<String> lst, StringBuilder sb){
        sb.append(root.val);
    
        if(root.left == null && root.right == null){
            lst.add(sb.toString());
            return;
        }
        
        if(root.left != null){
            int len = sb.length();
            sb.append("->");
            dfs(root.left, lst, sb);
            sb.setLength(len);
        }
        if(root.right != null){
            int len = sb.length();
            sb.append("->");
            dfs(root.right, lst, sb);
            sb.setLength(len);
        }
    }
}
