class Solution {
    
    // See no of sign changes in difference of subsequent elements.
    // A[1] should be strictly greater than A[0].
    // All difference elements should be either < or > 0.
    
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int[] diff = new int[A.length - 1];
        
        for (int i = 0; i < A.length - 1; i++) {
            diff[i] = A[i + 1] - A[i];
        }
        
        // get no of sign changes in diff
        int signChanges = 0;
        for (int i = 0; i < A.length - 2; i++) {
            if ((diff[i] < 0 && diff[i + 1] > 0) || (diff[i] > 0 && diff[i + 1] < 0)) {
                signChanges++;
            }
            if (diff[i] == 0) return false;
        }
        if (signChanges != 1) return false;
        
        if (A[1] < A[0]) return false;
        return true;
    }
}
