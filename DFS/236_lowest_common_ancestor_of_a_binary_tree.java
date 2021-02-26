/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Sol 1. DFS
//Time Complexity: O(n) with dfs
//Space Complexity: O(n)
class Solution {
    
    private TreeNode ans;

    public Solution() {
        this.ans = null;
    }
    
    private boolean dfs(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) return false;
        
        int left = this.dfs(cur.left, p, q)? 1:0;
        int right = this.dfs(cur.right, p, q)? 1:0;
        int mid = (cur == p || cur == q)? 1:0;
        
        if (mid + left + right >= 2)
            ans = cur;
        
        return (mid + left + right > 0);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }
}

//Sol 2. Iteration w/ parent pointers
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        stack.push(root);
        parent.put(root, null);
        
        while (!parent.containsKey(p)||!parent.containsKey(q)) { 
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        
        Set<TreeNode> lca = new HashSet<>();
        while (p != null) {
            lca.add(p);
            p = parent.get(p);
        }
        
        while (!lca.contains(q)) {
            q = parent.get(q);
        }
        
        return q;
    }
}
