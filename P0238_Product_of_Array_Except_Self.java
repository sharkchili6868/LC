class Solution {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		result[0] = 1;

		for(int i = 1; i < n; i++) {
			result[i] = nums[i - 1] * result[i - 1];
		}

		int right = 1;
		for(int i = n - 2; i >= 0; i--) {
            right = nums[i + 1] * right;
			result[i] = result[i] * right;
		}

		return result;
	}
}
// [1,2,3,4]
// [1,1,8,6]
// right = 1