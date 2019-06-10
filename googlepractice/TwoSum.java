class TwoSum {
    // Have a HashMap store target - nums[i] as key, index as value, check if i != indexMap.get(nums[i]) in second pass
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {           
                indexMap.put(target - nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
          if (indexMap.containsKey(nums[i])) {
              if (i !=  indexMap.get(nums[i])) {
                return new int[]{i, indexMap.get(nums[i])};
              } else {
                  continue;
              }
          }  
        }
        
        return  new int[]{-1, -1};
    } 
}
