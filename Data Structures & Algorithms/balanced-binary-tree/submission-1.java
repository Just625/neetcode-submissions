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
    // boolean isBalancedTree = true;
    public boolean isBalanced(TreeNode root) {
        // For every node, we calculate left and right subtree and compare
        // If all is true then it is a balanced tree?
        // getHeight(root);
        // return isBalancedTree;

        return getHeight(root) == -1 ? false : true;
    }

    // return -1 if tree is not balanced
    public int getHeight(TreeNode cur) {
        if (cur == null) return 0;

        int leftHeight = getHeight(cur.left);
        if (leftHeight == -1) return -1;

        int rightHeight = getHeight(cur.right);
        if (rightHeight == -1) return -1;

        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) {
        //    isBalancedTree = false;
            return - 1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

}
