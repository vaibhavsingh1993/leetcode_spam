/*O(nlogn) time, O(n space)*/
/* In dp array search for elements larger than prev element. If curr element is larger append to dp array else replace*/
/* https://www.youtube.com/watch?v=1RpMc3fv0y4 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        
        for (int num: nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) i = -(i + 1);
            
            dp[i] = num;
            if (i == len) len++;
        }
        return len;
    }
}
