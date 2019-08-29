/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if (root == null) return true;
//         TreeNode left =  (root.left != null ? root.left : null);
//         TreeNode right = (root.right != null ? root.right : null);
        
//         //if (left == null && right != null) return false;
        
//         if (left != null) {
//             if (left.val >= root.val) {
//                 return false;
//             }
//         }
        
//         if (right != null) {
//             if (root.val >= right.val) {
//                 return false;
//             }
//         }
        
//         isValidBST(root.left);
//         isValidBST(root.right);
        
//         return true;
//     }
// }


// Run inorder traversal, put values in a list, ensure list values are monotonically increasing
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList();
        
        inOrder(root, list);
        
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
