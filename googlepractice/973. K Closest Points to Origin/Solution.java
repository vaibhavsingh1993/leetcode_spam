// class Solution {
//     public int[][] kClosest(int[][] points, int K) {
        
//         if(K == points.length) return points;
        
//         Queue<Integer> minHeap = new PriorityQueue();
//         Map<Integer, Integer> hm = new HashMap();
        
//         int[][] ans = new int[points.length - 1][points[0].length - 1];
//         int len = points.length;
        
//         for (int i = 0; i < len; i++) {
//             int x = points[i][0];
//             int y = points[i][1];
//             minHeap.add(x*x + y*y);
            
//             hm.put(x*x + y*y, i);

//         }
        
//         for (int i = 0; i < K; i++) {
//             int shortestLen = hm.get(minHeap.remove());
//             ans[i] = points[shortestLen];
//         }
        
//         return ans;
//     }
// }

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }
}
