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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> lis = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            double sum = 0.0;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            lis.add(sum / size);
        }
        return lis;
    }
}
