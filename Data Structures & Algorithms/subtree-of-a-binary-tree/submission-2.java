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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Find node in Root that has the same value as subRoot first
            // Then just check if two tree are the same
        // Keep repeating the finding process because root may have many nodes that has the same value as subRoot
        TreeNode compareNode = null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur.val == subRoot.val) {
                compareNode = cur;
                if (isSameTree(compareNode, subRoot)) return true;
            }

            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        
        return false;
    }

    public boolean isSameTree(TreeNode firstNode, TreeNode secondNode) {
        if (firstNode == null && secondNode == null) return true;
        if (firstNode == null || secondNode == null) return false;
        if (firstNode.val != secondNode.val) return false;

        return isSameTree(firstNode.left, secondNode.left) && isSameTree(firstNode.right, secondNode.right);
    }
}
