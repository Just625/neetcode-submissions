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
        // Time O(n^2), Space O(n)
        // Because for every node we have to recalculate the height of its sub-tree in the getHeight method
        // int ans = 0;
        // Deque<TreeNode> stack = new ArrayDeque<>();
        // stack.push(root);

        // while (!stack.isEmpty()) {
        //     TreeNode cur = stack.pop();
        //     // For every node, the diameter will be the sum of the height of its left tree and 
        //     // its right tree
        //     int diameterThroughCurrent = getHeight(cur.left) + getHeight(cur.right);
        //     ans = Math.max(ans, diameterThroughCurrent);

        //     if (cur.left != null) stack.push(cur.left);
        //     if (cur.right != null) stack.push(cur.right);
        // }
        
        // return ans;

        // Using a global ans variable, while calculating the height, we can also check diameter
        // Time O(n), Space O(n)
        getHeight(root);
        return ans;
    }

    // Longest downward path starting from current node
    // public int getHeight(TreeNode cur) {
    //     if (cur == null) return 0;
    //     // The height of a tree will be the highest depth of its, so we will recursively check 
    //     // its left and right 
    //     int heightLeft = getHeight(cur.left);
    //     int heightRight = getHeight(cur.right);

    //     // Height = current node + max(left subtree height, right subtree height)
    //     return 1 + Math.max(heightLeft, heightRight);
    // }

    // While get height, we already have enough information to get diamter
    public int getHeight(TreeNode cur) {
        if (cur == null) return 0;

        int heightLeft = getHeight(cur.left);
        int heightRight = getHeight(cur.right);
        int diameterThroughCurrent =heightLeft + heightRight;
        ans = Math.max(ans, diameterThroughCurrent);

        return 1 + Math.max(heightLeft, heightRight);
    }
}
