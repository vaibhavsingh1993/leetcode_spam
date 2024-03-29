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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList();
        
        inorderTraverse(root, in);
        
        return in;
    }
    
    private void inorderTraverse(TreeNode root, List<Integer> in) {
        if (root == null) return;
        inorderTraverse(root.left != null ? root.left : null, in);
        in.add(root.val);
        inorderTraverse(root.right != null ? root.right : null, in);
        
        
    }
}

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;

    while(cur!=null || !stack.empty()){
        while(cur!=null){
            stack.add(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        list.add(cur.val);
        cur = cur.right;
    }

    return list;
}
