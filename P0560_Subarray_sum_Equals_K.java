class Solution {
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		int presum = 0;
		int result = 0;
		map.put(0, 1);

		for(int i = 0; i < nums.length; i++) {
			presum += nums[i];

			if (map.containsKey(presum - k)) {
				result += map.get(presum - k);
			}

			map.put(presum, map.getOrDefault(presum, 0) + 1);
		}

		return result;
	}
}
// 0 1 2 3
// 1 2 4 6
// 
// map
// 0 -> 1
// 1 -> 1
// 3 -> 1