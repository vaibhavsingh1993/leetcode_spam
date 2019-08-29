class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        if (n * m == 0) return n + m;
        
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // If last char is same
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Don't do anything new    
                } else {
                    // If last char is different
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);    
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    
    private int min(int a, int b, int c) {
        if (a < b && a < c) return a;
        else if (b < a && b < c) return b;
        else return c;
    }
}
