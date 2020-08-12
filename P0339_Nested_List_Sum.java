class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }
    
    private int dfs(List<NestedInteger> nestedList, int depth) {
        int result = 0;
        for(NestedInteger ele : nestedList) {
            if (ele.isInteger()) {
                result += ele.getInteger() * depth;
            } else {
                result += dfs(ele.getList(), depth + 1);
            }
        }
        
        return result;
    }
}
