/* O(n^2) time, O(n) complexity. */
/* Start from the beginning, have 2 pointers i and j, if lagging pointer j is smaller than i change len[i] to lagging pointer's dp value + 1*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = 1;
        int[] len = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            len[i] = 1;
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i] && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                }
                if (ans < len[i]) ans = len[i];
            }
        }
        
        
        return ans;
    }
}
