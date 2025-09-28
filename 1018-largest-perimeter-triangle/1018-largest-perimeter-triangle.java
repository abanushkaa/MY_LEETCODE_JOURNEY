import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);  // Sort ascending
        int n = nums.length;

        // Check from largest triplets
        for (int i = n - 1; i >= 2; i--) {
            int a = nums[i - 2], b = nums[i - 1], c = nums[i];
            if (a + b > c) {  // Valid triangle
                return a + b + c;
            }
        }
        return 0; // No valid triangle
    }
}
