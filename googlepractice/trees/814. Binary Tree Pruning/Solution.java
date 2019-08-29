public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        
        TreeNode newTree = new TreeNode(val);
        
        newTree.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newTree.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
        
        return newTree;
    }
}
