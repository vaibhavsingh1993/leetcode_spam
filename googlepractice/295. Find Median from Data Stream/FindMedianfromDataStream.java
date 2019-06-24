class FindMedianfromDataStream {

    /** initialize your data structure here. */
    PriorityQueue<Integer> highers;
    PriorityQueue<Integer> lowers;
    
    public FindMedianfromDataStream() {
        PriorityQueue<Integer> highers = new PriorityQueue<Integer>(); // minheap;
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>((x, y) -> y - x); // maxheap
        
    }
    
    public void addNum(int num) {
        if (lowers.isEmpty() || num <= lowers.peek()) {
            lowers.add(num);
        } else {
            highers.add(num);
        }
        rebalance(highers, lowers);
    }
    
    public double findMedian() {
        if ((highers.size() + lowers.size()) % 2 == 0) {
            //return ((double)(highers.peek() + lowers.peek()) / 2);
             return ((highers.peek() + lowers.peek()) / 2.0);
        } 
        else {
          return highers.peek() != null ? highers.peek() : lowers.peek();  
        } 
    }
    
    private void rebalance(PriorityQueue<Integer> highers, PriorityQueue<Integer> lowers) {
        PriorityQueue<Integer> bigger = highers.size() > lowers.size() ? highers : lowers;
        PriorityQueue<Integer> smaller = highers.size() > lowers.size() ? lowers : highers;
        
        int sizeDiff = bigger.size() - smaller.size();
        if ( sizeDiff > 1) {
            for (int i = 0; i < sizeDiff; i++) {
                smaller.add(bigger.poll());
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
