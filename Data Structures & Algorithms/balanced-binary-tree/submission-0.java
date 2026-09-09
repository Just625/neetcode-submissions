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
    boolean isBalancedTree = true;
    public boolean isBalanced(TreeNode root) {
        // For every node, we calculate left and right subtree and compare
        // If all is true then it is a balanced tree?
        getHeight(root);

        return isBalancedTree;
    }

    public int getHeight(TreeNode cur) {
        if (cur == null) return 0;

        int leftHeight = getHeight(cur.left);
        int rightHeight = getHeight(cur.right);
        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) {
           isBalancedTree = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

}
