/*G(n, r) = G(n - 1) * G() */
class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        int[] cache = new int[n + 1];
        
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                cache[i] += cache[j - 1] * cache[i - j];
            }
        }
    return cache[n];
    }
}
