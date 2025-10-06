import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); 
        // pq stores {elevation, row, col}
        
        pq.offer(new int[]{grid[0][0], 0, 0});
        int res = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int h = curr[0], r = curr[1], c = curr[2];
            
            // update max elevation seen
            res = Math.max(res, h);
            
            // if we reach destination
            if (r == n - 1 && c == n - 1) return res;
            
            // mark visited
            if (visited[r][c]) continue;
            visited[r][c] = true;
            
            // explore 4 neighbors
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    pq.offer(new int[]{grid[nr][nc], nr, nc});
                }
            }
        }
        
        return -1; // should never reach
    }
}
