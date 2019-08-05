/* DP solution O(n^2)
    To check whether string, start, end is a palindrome check whether string, start + 1, end - 1 was a palindrome and whether first and last characters are the same.
*/
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        
        if (s == null || len < 2) return s;
        boolean[][] memo = new boolean[len][len];
        int start = 0, end = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                boolean innerStringIsPalindrome = memo[i+1][j-1] || (j - i <= 2);       
                // When inner string is palindrome check if outer chars are same
                if (innerStringIsPalindrome && (s.charAt(i) == s.charAt(j))) {
                    memo[i][j] = true;
                    if (j - i > end - start) {
                        // Update longest substring
                        end = j;
                        start = i;
                    }
                }
            }
        }   
        return s.substring(start, end + 1);
    }
}
