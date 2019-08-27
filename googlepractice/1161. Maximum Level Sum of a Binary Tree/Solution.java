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
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        TreeNode first = root;
        Map<Integer, Integer> levelSum = new HashMap();
        dfs(root, levelSum, 1);
        
        
        int key = -1, val = -1000;
        for (Map.Entry<Integer, Integer> keySet : levelSum.entrySet()) {
            int prev = val;
            val = Math.max(keySet.getValue(), val);
            if (prev != val) {
                key = keySet.getKey();
            }
        } 
        
        return key;
    }
    
    // private void dfs(TreeNode root, Map<Integer, Integer> sum, int level) {
    //     sum.put(level, sum.getOrDefault(level, 0) + root.val );
    //     if(root.left != null) {
    //         dfs(root.left, sum, level + 1);
    //     }
    //     if (root.right != null) {
    //         dfs(root.right, sum, level + 1);
    //     }
    // }
    
    
}
