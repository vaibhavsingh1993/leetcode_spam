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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        
        HashMap<Integer, ArrayList<TreeNode>> map = new HashMap();
        
        TreeNode temp = root;
        insertIntoMap(root, map, 0);
        
        //System.out.println(map.entrySet());
        
        Object[] keys = map.keySet().toArray(); 
        Arrays.sort(keys);
        
        for (int i = 0; i < keys.length; i++) {
            List<Integer> lis = new ArrayList<Integer>();
            for (TreeNode l : map.get(keys[i])) {
                lis.add(l.val);
        //        System.out.println(lis);
            }
            ans.add(lis);
        }
        
        return ans;
    }
    
    
    /* Maintain ordering of nodes based on whether they came left or right of the parent node*/
    private void insertIntoMap(TreeNode node, Map<Integer, ArrayList<TreeNode>> map, int order) {
        ArrayList<TreeNode> tree = map.getOrDefault(order, new ArrayList());
        tree.add(node);
        map.put(order, tree);
        
        if (node.left != null) {
            insertIntoMap(node.left, map, order - 1);
        }
        if (node.right != null) {
            insertIntoMap(node.right, map, order + 1);
        }
    }
}
