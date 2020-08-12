class Solution {
    public boolean isMonotonic(int[] A) {
        boolean up = false;
        boolean down = false;
        
        for(int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) up = true;
            if (A[i - 1] > A[i]) down = true;
        }
        
        return up && down ? false : true;
    }
}
