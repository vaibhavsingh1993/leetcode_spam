// Queue + HashMap implementation. For every get update queue with the key being fetched.

class LRUCache {
    
    HashMap<Integer, Integer> cache = new HashMap();
    Queue<Integer> keys = new LinkedList(); 
    int capacity = 0;
    int currCapacity = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int ret = cache.getOrDefault(key, -1);
        //System.out.println(cache);
        // Update cache with newly fetched value
        if (ret != -1 && keys.size() > 0) {
            keys.remove(key);
            keys.add(key);
            //System.out.println(cache);
        }
        return ret;
    }
    
    public void put(int key, int value) {
        // If capacity increases remove oldest key
        if(currCapacity >= capacity) {
            
            int keyToRemove = keys.remove();
            cache.remove(keyToRemove);
            
            currCapacity--;
        }
        // Put new key and value
        cache.put(key, value);
        //System.out.println("in put");
        //System.out.println(cache);
        keys.add(key);
        currCapacity++;
        //System.out.println(keys);
    }
}

// /**
//  * Your LRUCache object will be instantiated and called as such:
//  * LRUCache obj = new LRUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */

// class LRUCache extends LinkedHashMap<Integer, Integer>{
//     private int capacity;
    
//     public LRUCache(int capacity) {
//         super(capacity, 0.75F, true);
//         this.capacity = capacity;
//     }

//     public int get(int key) {
//         return super.getOrDefault(key, -1);
//     }

//     public void put(int key, int value) {
//         super.put(key, value);
//     }

//     @Override
//     protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//         return size() > capacity; 
//     }
// }
