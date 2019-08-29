/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int val = 0;
    public TreeNode bstToGst(TreeNode root) {
        bstToGst(root, 0);
        return root;
    }
    
    private void bstToGst(TreeNode root, int keyval) {
        if (root == null) return;
        if (root.right != null) bstToGst(root.right, val);
        root.val += val;
        val = root.val;
        if (root.left != null) bstToGst(root.left, val);
    }
}
