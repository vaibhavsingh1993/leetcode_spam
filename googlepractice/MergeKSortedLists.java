class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        
        Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>(){
            @Override public int compare(ListNode l1, ListNode l2) { 
                return l1.val - l2.val; 
            }
        });
        
        ListNode head = new ListNode(0), tail = head;
        // Add first nodes of all linked lists to Priority Queue
        for (ListNode node : lists) if (node != null) heap.offer(node);
        
        while(!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            // Add new node referenced by tail to Priority Queue
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
    }
}
