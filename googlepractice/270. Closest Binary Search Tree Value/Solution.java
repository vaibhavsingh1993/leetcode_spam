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
//     public int closestValue(TreeNode root, double target) {
//         boolean leftExists = (root.left != null);
//         boolean rightExists = (root.right != null);
        
//         if (!leftExists && !rightExists) return root.val;
        
//         double delta = Math.abs(target - root.val);
//         double deltaLeft = Double.MAX_VALUE;
//         double deltaRight = Double.MAX_VALUE;
        
//         if (leftExists) deltaLeft = Math.abs(target - root.left.val);
//         if (rightExists) deltaRight = Math.abs(target - root.right.val);
        
//         if (delta < deltaLeft && delta < deltaRight) {
//             return root.val;
//         } else if (deltaLeft < delta && deltaLeft < deltaRight) {
//             return closestValue(root.left, target);
//         } else {
//             return closestValue(root.right, target);
//         }
//     }
// }

class Solution {
  public int closestValue(TreeNode root, double target) {
    int val, closest = root.val;
    while (root != null) {
      val = root.val;
      closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
      root =  target < root.val ? root.left : root.right;
    }
    return closest;
  }
}
