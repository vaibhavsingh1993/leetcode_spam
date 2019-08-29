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
    public void flatten(TreeNode root) {
        List<Integer> list = new ArrayList();
        preOrder(root, list);
        
        TreeNode newroot = new TreeNode(list.get(0));
        TreeNode temp = newroot;
        for (int i = 1; i < list.size(); i++) {
            temp.right = new TreeNode(list.get(i));
            temp = temp.right;
        }
        
        root = newroot;
    }
    
    private void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        list.add(root.val);
        
        if (root.left != null) preOrder(root.left, list);
        if (root.right != null) preOrder(root.right, list);
    }
}
