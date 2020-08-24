class Solution {
	public int trap(int[] H) {
		int left = 0;
		int right = H.length - 1;
		int result = 0;
		int maxleft = 0;
		int maxright = 0;

		while(left <= right) {
			if (H[left] <= H[right]) {
				if (H[left] > maxleft) maxleft = H[left];
				else result += maxleft - H[left];
				left++;
			} else {
				if (H[right] >= maxright) maxright = H[right];
				else result += maxright - H[right];
				right--;
			}
		}

		return result;
	}
}