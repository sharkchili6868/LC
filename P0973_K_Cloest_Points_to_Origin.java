class Solution {
	public int[][] kClosest(int[][] points, int K) {
		quickSort(points, K, 0, points.length - 1);

		return Arrays.copyOfRange(points, 0, K);
	}

	private void quickSort(int[][] points, int K, int lo, int hi) {
		if (lo >= hi) return;
		int partition = partition(points, lo, hi);
		if (partition == K) {
			return;
		} else if (partition < K) {
			quickSort(points, K, partition + 1, hi);
		} else {
			quickSort(points, K, lo, partition - 1);
		}
	}

	private int partition(int[][] points, int lo, int hi) {
		int[] pivot = points[hi];
		int s = lo;
		for(int i = lo; i < hi; i++) {
			if (calculate(points[i]) < calculate(pivot)) {
				swap(points, s++, i);
			}
		}
		swap(points, s, hi);

		return s;
	}

	private void swap(int[][] points, int i, int j) {
		int[] temp = points[i];
		points[i] = points[j];
		points[j] = temp;
	}

	private int calculate(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	} 
}