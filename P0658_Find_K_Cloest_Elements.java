class Solution {
	public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int l = 0;
		int r = nums.length - k;

		while(l < r) {
			int mid = l + (r - l) / 2;
			if (x - nums[mid] > nums[mid + k] - x) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}

        List<Integer> result = new ArrayList<>();

        for(int i = l; i < l + k; i++) {
            result.add(nums[i]);
        }
        
        return result;
    }
}