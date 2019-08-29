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
//     public boolean isSymmetric(TreeNode root) {
//         if (root == null) return true;
//         if (root.left == null && root.right == null) return true;
//         List<Integer> list = new ArrayList();
        
//         inOrder(root, list);
        
//         int n = list.size();
        
//         List<Integer> origList = new ArrayList();
        
//         for (int i : list) {
//             origList.add(i);
//         }
//         Collections.reverse(list);
        
//         for (int i = 0; i < n; i++) {
//             //System.out.println(list.get(i));
//             //System.out.println(origList.get(i));
//             if (list.get(i) != origList.get(i)) {
//                 return false;
//             }
//         }
        
//         return true;
//     }
    
//     private void inOrder(TreeNode root, List<Integer> list) {
//         if (root == null) {
//             return;
//         }
        
//         inOrder(root.left, list);
        
//         list.add(root.val);
        
//         if (root.left != null && root.right == null) {
//             list.add(-1);
//         }
//         inOrder(root.right, list);
//     }
    
    
public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
}

public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val)
        && isMirror(t1.right, t2.left)
        && isMirror(t1.left, t2.right);
}
}
