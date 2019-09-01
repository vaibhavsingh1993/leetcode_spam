// Climb from left and right, if you meet at the same point then true.
class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int first = 0, last = A.length - 1;
        
        while(A[first] < A[first + 1] && (first + 1) < A.length - 1) first++;
        
        while(A[last] < A[last - 1] && (last - 1) > 0) last--;
        
        if (first == last) return true;
        return false;
    }
}
