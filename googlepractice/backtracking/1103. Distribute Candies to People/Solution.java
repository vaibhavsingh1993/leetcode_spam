class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int candiesLeft = candies;
        int[] ans = new int[num_people];
        
        int i = 0, count = 0;
        while(candiesLeft > 0) {
            ans[i] += Math.min(candiesLeft, (count + 1));
            candiesLeft -= (count + 1);
            i++;
            count++;
            if (i > (num_people - 1)) {
                i = 0;
            }
        }
        return ans;
    }
}
