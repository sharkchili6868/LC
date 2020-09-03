class Solution {
    int start = 0;
    public TreeNode str2tree(String s) {
        return dfs(s);
    }
    
    private TreeNode dfs(String s) {
        if (start >= s.length()) return null;
        
        boolean isNeg = false;
        if (s.charAt(start) == '-') {
            isNeg = true;
            start++;
        }
        
        int num = 0;
        while(start < s.length() && Character.isDigit(s.charAt(start))) {
            num = num * 10 + s.charAt(start) - '0';
            start++;
        }
        
        if (isNeg) num = -num;
        
        TreeNode root = new TreeNode(num);
        if (start >= s.length()) {
            return root;
        }
        
        if (start < s.length() && s.charAt(start) == '(') {
            start++;
            root.left = dfs(s);
        }
        
        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return root;
        }
        
        if (start < s.length() && s.charAt(start) == '(') {
            start++;
            root.right = dfs(s);
        }
        
        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return root;
        }
        
        return root;
    }
}