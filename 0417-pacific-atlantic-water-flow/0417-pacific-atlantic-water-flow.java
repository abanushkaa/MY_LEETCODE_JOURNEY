import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Run DFS from all Pacific-border and Atlantic-border cells
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);       // Left edge (Pacific)
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]); // Right edge (Atlantic)
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);       // Top edge (Pacific)
            dfs(heights, atlantic, m - 1, j, heights[m - 1][j]); // Bottom edge (Atlantic)
        }

        // Collect cells reachable by both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        // Out of bounds or already visited or cannot flow uphill
        if (r < 0 || c < 0 || r >= m || c >= n ||
            visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        // Explore 4 directions
        dfs(heights, visited, r + 1, c, heights[r][c]);
        dfs(heights, visited, r - 1, c, heights[r][c]);
        dfs(heights, visited, r, c + 1, heights[r][c]);
        dfs(heights, visited, r, c - 1, heights[r][c]);
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] heights = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        System.out.println(sol.pacificAtlantic(heights));
        // Expected: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
    }
}
