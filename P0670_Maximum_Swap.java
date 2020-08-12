class Solution {
   public int maximumSwap(int num) {
        if (num < 12) return num;
        int[] lastSeen = new int[10];
        
        char[] n = Integer.toString(num).toCharArray();
        for(int i = 0; i < n.length; i++) {
            lastSeen[n[i] - '0'] = i;
        }
        
        for(int i = 0; i < n.length; i++) {
            for(int j = 9; j > n[i] - '0'; j--) {
                if (lastSeen[j] > i) {
                    swap(i, lastSeen[j], n);
                    return Integer.valueOf(new String(n));
                }
            }
        }
        
        return num;
    }
    
    private void swap(int i, int j, char[] A) {
        char temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
