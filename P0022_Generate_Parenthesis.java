class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, n, new StringBuilder(), result);
        return result;
    }
    
    private void dfs(int l, int r, int n, StringBuilder temp, List<String> result) {
        if (temp.length() == n * 2) {
            result.add(temp.toString());
            return;
        }
        
        if (l < n) {
            dfs(l + 1, r, n, temp.append('('), result);
            temp.setLength(temp.length() - 1);
        }
        
        if (r < l) {
            dfs(l, r + 1, n, temp.append(')'), result);
            temp.setLength(temp.length() - 1);
        }
    }
}