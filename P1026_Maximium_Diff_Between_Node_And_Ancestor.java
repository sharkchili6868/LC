class Solution {
	public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int l, int r) {
    	if (root == null) return 0;

    	int curMax = Math.max(Math.abs(root.val - l), Math.abs(root.val - r));

    	l = Math.min(l, root.val);
    	r = Math.max(r, root.val);

    	return Math.max(curMax, 
    		Math.max(dfs(root.left, l, r), dfs(root.right, l, r)));
    }
}