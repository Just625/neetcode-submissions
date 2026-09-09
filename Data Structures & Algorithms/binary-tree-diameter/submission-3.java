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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // Time O(n), Space O(n)
        getHeight(root);
        return ans;
    }
    
    // This method return the height of the current subtree to its parent. While computing that height, we alreayd have
    // enough information to calculate its dimeter throught current node (which is leftHeight + rightHeight). This way each node is processed only once.
    public int getHeight(TreeNode cur) {
        if (cur == null) return 0;

        int leftHeight = getHeight(cur.left);
        int rightHeight = getHeight(cur.right);
        int diamterThroughCurNode = leftHeight + rightHeight;

        ans = Math.max(ans, diamterThroughCurNode);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
