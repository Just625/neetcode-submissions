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
    public int maxDepth(TreeNode root) {
        // Time O(n), Space O(n)
        if (root == null) return 0;

        int ans = 1;
        // DFS, using treeNode val as a place holder for current step
        Deque<TreeNode> stack = new ArrayDeque<>();
        root.val = 1;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans = Math.max(ans, cur.val);

            TreeNode left = cur.left;
            if (left != null) {
                left.val = cur.val + 1;
                stack.push(left);
            }

            TreeNode right = cur.right;
            if (right != null) {
                right.val = cur.val + 1;
                stack.push(right);
            }
        }

        return ans;
    }
}
