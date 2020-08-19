class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) return result;
        
        int l = 0;
		int r = nums.length - 1;


		while(l < r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid;
			}
		} 

		if (nums[l] != target) return result;
		else result[0] = l;

		r = nums.length - 1;
		while(l < r) {
			int mid = l + (r - l) / 2 + 1;
			if (nums[mid] > target) {
				r = mid - 1;
			} else {
				l = mid;
			}
		}

		result[1] = r;
		
		return result;
    }
}