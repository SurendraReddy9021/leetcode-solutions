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
    int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        return max;
    }

    // left = 0, right = 1
    private void dfs(TreeNode node, int left, int right) {
        if (node == null) {
            return;
        }

        max = Math.max(max, Math.max(left, right));

        // If we go left, next must go right
        dfs(node.left, right + 1, 0);

        // If we go right, next must go left
        dfs(node.right, 0, left + 1);
    }
}