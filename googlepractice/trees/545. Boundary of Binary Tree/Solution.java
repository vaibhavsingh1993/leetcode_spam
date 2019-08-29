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
//     public List<Integer> boundaryOfBinaryTree(TreeNode root) {
//         // BFS, store first elements in arraylist for left view, right elements in arraylist for right view, and bottom view as last layer for the tree
//         if (root == null) return new ArrayList();
        
//         Queue<TreeNode> queue = new LinkedList();
//         List<Integer> left = new ArrayList();
//         List<Integer> right = new ArrayList();
//         List<Integer> leaves = new ArrayList();
//         List<Integer> ans = new ArrayList();
        
//         if (root.left != null) {
//             left.add(root.left.val);
//             getLeftBoundary(root.left, left);
//         }
        
//         getLeaves(root, leaves);
//         if (root.right != null) {
//             right.add(root.right.val);
//             getRightBoundary(root.right, right);
//         }
//         Collections.reverse(right);
        
//         //System.out.println(left);
//         //System.out.println(right);
//         //System.out.println(leaves);
        
//         ans.add(root.val);
//         for (int i : left) {
//             if (!ans.contains(i))
//                 ans.add(i);
//         }
        
//         for (int i : leaves) {
//             if (!ans.contains(i))
//                 ans.add(i);
//         }
        
//         for (int i : right) {
//             if (!ans.contains(i))
//                 ans.add(i);
//         }
        
        
//         return ans;
//     }
    
//     private void getLeftBoundary(TreeNode root, List<Integer>left) {
//         if (root == null) return;
//         if (root.left != null) {
//             left.add(root.left.val);
//             getLeftBoundary(root.left, left);
//         }
        
//         if (root.right != null) {
//             getLeftBoundary(root.right, left);
//         }
        
//         if (root.left == null && root.right != null) {
//             left.add(root.right.val);
//             getLeftBoundary(root.right, left);
//         }
        
        
        
//     }
    
//     private void getRightBoundary(TreeNode root, List<Integer>right) {
//         if (root == null) return;
//         if (root.right != null) {
//             right.add(root.right.val);
//             getRightBoundary(root.right, right);
//         }
        
//         if (root.left != null) {
//             getRightBoundary(root.left, right);
//         }

//         if (root.right == null && root.left != null) {
//             right.add(root.left.val);
//             getRightBoundary(root.left, right);
//         }
        
        
//     }
    
//     private void getLeaves(TreeNode root, List<Integer> leaves) {
//         if (root == null) return;
//         if (root.left == null && root.right == null) leaves.add(root.val);
        
//         getLeaves(root.left, leaves);
//         getLeaves(root.right, leaves);
//     }
    
List<Integer> nodes = new ArrayList<>(1000);
public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    
    if(root == null) return nodes;

    nodes.add(root.val);
    leftBoundary(root.left);
    leaves(root.left);
    leaves(root.right);
    rightBoundary(root.right);
    
    return nodes;
}
public void leftBoundary(TreeNode root) {
    if(root == null || (root.left == null && root.right == null)) return;
    nodes.add(root.val);
    if(root.left == null) leftBoundary(root.right);
    else leftBoundary(root.left);
}
public void rightBoundary(TreeNode root) {
    if(root == null || (root.right == null && root.left == null)) return;
    if(root.right == null)rightBoundary(root.left);
    else rightBoundary(root.right);
    nodes.add(root.val); // add after child visit(reverse)
}
public void leaves(TreeNode root) {
    if(root == null) return;
    if(root.left == null && root.right == null) {
        nodes.add(root.val);
        return;
    }
    leaves(root.left);
    leaves(root.right);
}
    
}
