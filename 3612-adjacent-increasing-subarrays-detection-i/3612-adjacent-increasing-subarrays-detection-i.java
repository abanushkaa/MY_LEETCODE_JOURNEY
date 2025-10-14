import java.util.List;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        // a can go up to n - 2*k (because we need two adjacent subarrays of length k)
        for (int a = 0; a <= n - 2 * k; a++) {
            if (isStrictlyIncreasing(nums, a, k) && isStrictlyIncreasing(nums, a + k, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean isStrictlyIncreasing(List<Integer> nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) return false;
        }
        return true;
    }
}
