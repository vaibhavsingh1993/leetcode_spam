class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue((n1, n2) -> frequencyMap.get(n1) - frequencyMap.get(n2));
        
        for (int n : frequencyMap.keySet()) {
            pq.add(n);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        List<Integer> top = new ArrayList();
        
        while(!pq.isEmpty()) {
            top.add(pq.poll());
        }
        Collections.reverse(top);
        return top;
    }
}
