class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
            indegree[to]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> nextCourses = graph.get(cur);
            if (nextCourses != null) {
                for(int next : nextCourses) {
                    indegree[next]--;
                    if (indegree[next] == 0) queue.offer(next);
                }
            }
        }
        
        for(int num : indegree) {
            if (num != 0) return false;
        }
        
        return true;
    }
}