// Use MaxHeap

class KthLargestElementUnsortedArray {
    public int findKthLargest(int[] nums, int k) {
        // Priority Queue i java in Min Heap by default.
        PriorityQueue<Integer> maxHeap =  
             new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        
        for (int j = 0; j < k - 1; j++) {
            maxHeap.poll();
        }
        
        return maxHeap.poll();
    }
}
