class Solution {

	Random rand;
	int[] A;

    public Solution(int[] nums) {
    	this.rand = new Random();
    	this.A = nums; 
    }
    
    public int pick(int target) {
        int count = 0;
        int result = -1;

        for(int i = 0; i < A.length; i++) {
        	if (A[i] == target) {
        		count++;
        		if (i == 0 || rand.nextInt(count) == 0)
        			result = i;
        	}
        }

        return result;
    }
}