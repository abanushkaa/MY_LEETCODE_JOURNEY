class Solution {
    public int maxArea(int[] height) {
        int left = 0;                     // Start pointer
        int right = height.length - 1;    // End pointer
        int maxArea = 0;

        while (left < right) {
            // Calculate current area
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = h * width;

            // Update max area if larger
            maxArea = Math.max(maxArea, area);

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(sol.maxArea(new int[]{1,1}));               // 1
    }
}
