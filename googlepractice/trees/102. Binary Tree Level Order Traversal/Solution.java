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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> ans = new HashMap();
        levelOrder(root, 0, ans);
        
        List<List<Integer>> ans2 = new ArrayList();
        for (Map.Entry<Integer, List<Integer>> entry : ans.entrySet()) {
            ans2.add(entry.getValue());
        }
        return ans2;
    }
    
    private void levelOrder(TreeNode root, int level, Map<Integer, List<Integer>> ans) {
        if (root == null) return;
        List<Integer> lis = ans.getOrDefault(level, new ArrayList<Integer>());
        lis.add(root.val);
        ans.put(level, lis);
        if (root.left != null) levelOrder(root.left, level + 1, ans);
        if (root.right != null) levelOrder(root.right, level + 1, ans);
    }
}
