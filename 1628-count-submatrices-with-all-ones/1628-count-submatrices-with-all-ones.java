class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // heights[j] will store the count of consecutive 1's 
        // in column j up to the current row
        int[] heights = new int[n];

        int ans = 0; // final count of submatrices

        // Process each row one by one
        for (int i = 0; i < m; i++) {

            // Step 1: Update histogram (heights array) for this row
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    heights[j] = 0; // reset if cell is 0
                } else {
                    heights[j] += 1; // increase height if cell is 1
                }
            }

            // Step 2: For each column j, count submatrices ending at (i, j)
            for (int j = 0; j < n; j++) {
                if (heights[j] > 0) {
                    int minHeight = heights[j];

                    // Look leftwards (towards column 0) 
                    // and keep updating minHeight
                    for (int k = j; k >= 0 && heights[k] > 0; k--) {
                        minHeight = Math.min(minHeight, heights[k]);

                        // Each step adds "minHeight" rectangles
                        // ending at column j and row i
                        ans += minHeight;
                    }
                }
            }
        }

        return ans; // return final answer
    }
}
