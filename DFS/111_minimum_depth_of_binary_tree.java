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
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        int lmin = minDepth(root.left);
        int rmin = minDepth(root.right);
        
        if (lmin == 0) return rmin+1;
        if (rmin == 0) return lmin+1;
        
        return Math.min(lmin,rmin)+1;
    }
}
