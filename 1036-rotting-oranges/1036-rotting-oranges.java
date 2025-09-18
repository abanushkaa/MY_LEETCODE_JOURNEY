import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Count fresh oranges and add rotten oranges to queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If no fresh oranges, return 0
        if (freshCount == 0) return 0;
        
        int minutes = -1;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int r = orange[0], c = orange[1];
                
                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];
                    
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Rotten now
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        
        // Step 3: Check if fresh oranges remain
        return (freshCount == 0) ? minutes : -1;
    }
}
