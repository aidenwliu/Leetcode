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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        
        node_queue.addLast(root);
        node_queue.addLast(null);
        
        LinkedList<Integer> level = new LinkedList<Integer>();
        boolean left_order = true;
        
        while (node_queue.size()>0) {
            TreeNode cur = node_queue.pollFirst();
            if (cur != null) {
                if (left_order) {
                    level.addLast(cur.val);
                } else {
                    level.addFirst(cur.val);
                }
                if (cur.left != null) node_queue.addLast(cur.left);
                if (cur.right != null) node_queue.addLast(cur.right);
            } else {
                res.add(level);
                level = new LinkedList<Integer>();
                if (node_queue.size()>0) //time limit exceeded w/o this line
                    node_queue.addLast(null);
                left_order = !left_order;
            }
        }
        return res;
    }
}
