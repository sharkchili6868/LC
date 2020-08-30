class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while(!queue.isEmpty()) {
            int[] curPos = queue.poll();
            
            for(int[] dir : dirs) {
                int x = curPos[0] + dir[0];
                int y = curPos[1] + dir[1];
                
                if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] != Integer.MAX_VALUE) continue;
                
                rooms[x][y] = rooms[curPos[0]][curPos[1]] + 1;
                queue.offer(new int[]{x, y});
            }
        }
    }
}