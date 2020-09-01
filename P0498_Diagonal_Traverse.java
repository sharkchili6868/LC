class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
    	if (matrix == null || matrix.length == 0) {
    		return new int[]{};
    	}

    	int i = 0;
    	int j = 0;
    	int r = matrix.length;
    	int c = matrix[0].length;

    	int[] result = new int[r * c];
    	int k = 0;

    	for(int idx = 0; idx < r * c; idx++) {
    		result[idx] = matrix[j][i];

    		if (k % 2 == 0) {
    			// going up
    			if (j == 0 && i != c - 1) {
    				// touch upper bound, move right
    				i++;
    				k++;
    			} else if (i == c - 1) {
    				// touch right bound, move down
    				j++;
    				k++;
    			} else {
    				j--;
    				i++;
    			}
    		} else {
    			// going down
    			if (i == 0 && j != r - 1) {
    				// touch left bound
    				j++;
    				k++;
    			} else if (j == r - 1) {
    				// touch lower bound
    				i++;
    				k++;
    			} else {
    				i--;
    				j++;
    			}
    		}
    	}
    	return result;
    }
}