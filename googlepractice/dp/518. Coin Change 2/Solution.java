class Solution {
    public int change(int amount, int[] coins) {
        int[] count = new int[amount + 1];
        
        count[0] = 1;
        
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    count[j] += count[j - coins[i]];
                     //System.out.println(count[j]);
                }
            }
           
        }
        
        return count[amount];
    }
}
