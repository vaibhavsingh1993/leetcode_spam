class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] cache = new int[nums.length];
        cache[0] = nums[0]; // -2
        int ans = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            cache[i] = Math.max(nums[i], nums[i] + cache[i - 1]);
            //System.out.println(cache[i]);
            ans = Math.max(ans, cache[i]);
        }
        return ans;
    }
}
