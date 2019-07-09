/* O(n) time complexity O(n) space complexity */

/* Helpful resource https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49708/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0) return 0;
        int lead = 0, lag = 0, maxLen = 0, counter = 0;
        Map<Character, Integer> seen = new HashMap();
        
        while(lead < s.length()) {
            char leadChar = s.charAt(lead);
            seen.put(leadChar, seen.getOrDefault(leadChar, 0) + 1);
            if (seen.get(leadChar) == 1) counter++;
            lead++;
            
            while(counter > 2) {
                char lagChar = s.charAt(lag);
                seen.put(lagChar, seen.get(lagChar) - 1);
                if (seen.get(lagChar) == 0) counter--;
                lag++;
                
            }
            maxLen = Math.max(lead - lag, maxLen);
        }
        
        return maxLen;
    }
}
