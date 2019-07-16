// Bitwise XOR of all numbers cancels pairs out.
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }
}
