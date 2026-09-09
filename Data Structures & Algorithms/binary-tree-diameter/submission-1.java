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
    public int diameterOfBinaryTree(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            int heightLeft = getHeight(cur.left);
            int heightRight = getHeight(cur.right);
            ans = Math.max(ans, heightLeft + heightRight);

            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        
        return ans;
    }

    public int getHeight(TreeNode cur) {
        if (cur == null) return 0;

        if (cur.left == null && cur.right == null) return 1;

        int heightLeft = getHeight(cur.left);
        int heightRight = getHeight(cur.right);

        return 1 + Math.max(heightLeft, heightRight);
    }
}
