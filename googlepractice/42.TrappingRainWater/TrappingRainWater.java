/*
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * Idea is to first find "bowls" or indices in the array which are local minimas 
 * (index values to the immediate left and immediate right are higher than "bowl" index value)
 * Then for every "bowl" go left and right until the point where corresponding left and right value stops increasing.
 * The difference between left and right indices will be the "size" of the bowl where water can collect.
 * Then for all indices between left and right add Min(left index, right index) - height[currindex] to the running total "volume".
 * Time complexity O(n) although we do run throught the array twice
 * Space complexity O(n) as we need to store and process all array elements 
 */


// Works for [0,1,0,2,1,0,1,3,2,1,2,1]

class TrappingRainWater {
    public int trap(int[] height) {
        int volume = 0;
        List<Integer> bowls = new ArrayList();
        
        for (int i = 1; i < height.length - 1; i++) {
            // Check for minima
            if (height[i - 1] > height[i] && height[i + 1] > height[i]) {
                bowls.add(i); // Dont need value at local minimas now
            }
        }
        
        // Find the left and right "highest" points
        for (int bowl: bowls) {
            System.out.println("bowl is " + bowl);
            int left = bowl;
            int right = bowl;
            
            // Get left maxima
            for (int i = bowl; i > 0; i--) {
                if (height[i] > height[i - 1]) {
                    left = i; 
                    break;
                }
            }
            if (left == bowl) {
                left = 0;
            }
            
            System.out.println("left is " + left);
            
            // Get right maxima
            
            for (int i = bowl; i < height.length - 1; i++) {
                if (height[i] > height[i + 1]) {
                    right = i;
                    break;
                }
            }
            
            if (right == bowl) {
                right = height.length - 1;
            }
            
            System.out.println("right is " + right);
            
            for (int i = left; i <= right; i++) {
                if (Math.min(height[left], height[right]) - height[i] > 0) {
                    volume += Math.min(height[left], height[right]) - height[i];    
                }    
                
            }       
            System.out.println("volume is " + volume);
        }
        return volume;
    }   
}

