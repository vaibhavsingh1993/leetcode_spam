// Queue + HashMap based implementation
// This would not compile as size limited queues are not present in Java Collections package.
class LRUCache {
    Queue keystore;
    int currElements;
    
    public LRUCache(int capacity) {
        keystore = new Queue(capacity); // TODO: Find size limited queue implementations
        int currElements = 0;
    }
    
    
    // While getting the value, dequeue the value from the queue and enqueue again to move it     //to the top of the queue (latest elements are at the head of the queue) 
    public int get(int key) {
        Map values = keystore.get(key);
        if (values.get(key) != null) {
            HashMap hm = keystore.delete(key);
            keystore.queue(hm);
            return hm.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (currElements >= capacity) {
            keystore.dequeue();
            currElements--;
        }
        currElements++;
        keystore.queue(new HashMap().put(key, value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

