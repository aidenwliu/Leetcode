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
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] max = {Integer.MIN_VALUE};
        branchSum(max, root);
        return max[0];
    }
    public int branchSum(int[] max, TreeNode root) {
        if (root== null) return 0;
        int leftSum = branchSum(max, root.left);
        int rightSum = branchSum(max, root.right);
        int branchMax = root.val + Math.max(0, Math.max(leftSum, rightSum));
        max[0] = Math.max(max[0],Math.max(branchMax,root.val+leftSum+rightSum));
        return branchMax;
    }
}
