// class TwoSum {
//     // Have a HashMap store target - nums[i] as key, index as value, check if i != indexMap.get(nums[i]) in second pass
//     public int[] twoSum(int[] nums, int target) {
//         Map<Integer, Integer> indexMap = new HashMap();
//         for (int i = 0; i < nums.length; i++) {           
//                 indexMap.put(target - nums[i], i);
//         }
        
//         for (int i = 0; i < nums.length; i++) {
//           if (indexMap.containsKey(nums[i])) {
//               if (i !=  indexMap.get(nums[i])) {
//                 return new int[]{i, indexMap.get(nums[i])};
//               } else {
//                   continue;
//               }
//           }  
//         }
        
//         return  new int[]{-1, -1};
//     } 
// }


/* One pass solution*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap();
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(target - nums[i])) {         
                result [1] = i;
                result[0] = cache.get(target - nums[i]);
                return result;
            }
            cache.put(nums[i], i);
        }
        return result;
    }
}
