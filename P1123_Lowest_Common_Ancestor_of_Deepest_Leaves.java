class Solution {
	int max = -1;
	TreeNode LCA = null;
	public TreeNode lcaDeepestLeaves(TreeNode root) {
		dfs(root, 0);
		return LCA;
	}

	public int dfs(TreeNode root, int depth) {
		if (root == null) return depth - 1;

		int left = dfs(root.left, depth + 1);
		int right = dfs(root.right, depth + 1);

		if (depth > max) max = depth;
		if (left == max && right == max) LCA = root;

		return Math.max(left, right);
	}
}