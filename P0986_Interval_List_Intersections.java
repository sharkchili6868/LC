class Solution {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
        int len1 = A.length;
        int len2 = B.length;
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i < len1 && j < len2) {
        	int s1 = A[i][0];
        	int e1 = A[i][1];

        	int s2 = B[j][0];
        	int e2 = B[j][1];

        	if (s2 > e1) i++;
        	else if (s1 > e2) j++;
        	else {
        		int[] overlap = new int[2];
        		overlap[0] = Math.max(s1, s2);
        		overlap[1] = Math.min(e1, e2);
        		result.add(overlap);

        		if (e1 > e2) j++;
        		if (e2 >= e1) i++;
        	}
        }

        return result.toArray(new int[result.size()][2]);
    }
}