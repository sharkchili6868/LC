class Solution {
	public String minRemoveToMakeValid(String s) {
		Deque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder(s);

		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else if (s.charAt(i) == ')') {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					sb.setCharAt(i, '%');
				}
			}
		}

		while(!stack.isEmpty()) {
			sb.setCharAt(stack.pop(), '%');
		}

		return sb.toString().replaceAll("\\%", "");
	}
}