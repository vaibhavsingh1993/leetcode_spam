/* O(nm) time O(nm) space complexity */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        //System.out.println(text1.substring(0, text1.length() - 1));
        
        //return topDown(text1, text2);
        
        return bottomUp(text1, text2);
    }
    
    private int topDown(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;
        String text1WithoutFinalChar = text1.substring(0, text1.length() - 1);
        String text2WithoutFinalChar = text2.substring(0, text2.length() - 1);
        
        
        if (text1.charAt(text1.length() - 1) == text2.charAt(text2.length() - 1)) {
            return 1 + topDown(text1WithoutFinalChar, text2WithoutFinalChar);
        } else {
            return Math.max(topDown(text1, text2WithoutFinalChar),    topDown(text1WithoutFinalChar, text2));
        }
    }
    
    private int bottomUp(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;
        int[][] cache = new int[text1.length() + 1][text2.length() + 1];
        
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0;
                }
                else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1] + 1;
                } else {
                    cache[i][j] = Math.max(cache[i][j - 1], cache[i - 1][j]);
                }
            }
        }
        
        return cache[text1.length()][text2.length()];
    }
}
