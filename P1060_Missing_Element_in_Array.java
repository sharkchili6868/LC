class Solution {
	public int missingElement(int[] nums) {
		int l = 0;
		int r = nums.length - 1;

		while(l <= r) {
			mid = l + (r - l) / 2;
			if (missingNum(mid) < k) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}

		return nums[l - 1] + k - missingNum(l - 1);
	}


	private int missingNum(int[] nums, int i) {
		return nums[i] - nums[0] - i;
	}
}