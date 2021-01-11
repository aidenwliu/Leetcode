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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isFirst = false;
        int left_val = 0;
        while (!queue.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
            isFirst = true;
            while (!queue.isEmpty()) {
                TreeNode top = queue.poll();
                if (isFirst) {
                    left_val = top.val;
                    isFirst = false;
                }
                if (top.left == null && top.right == null) continue;
                if (top.left != null) {
                    queue2.offer(top.left);
                }
                if (top.right != null) {
                    queue2.offer(top.right);
                }
            }
            queue = queue2;
        }
        return left_val;
    }
}
