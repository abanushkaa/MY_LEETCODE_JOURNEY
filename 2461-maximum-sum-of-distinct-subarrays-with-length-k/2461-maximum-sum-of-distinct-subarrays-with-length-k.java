import java.util.HashMap;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;
        long sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        long max = 0;

        // Check first window
        if (map.size() == k) {
            max = sum;
        }

        int low = 0;
        int high = k - 1;

        while (high < n - 1) {

            // Remove left element
            sum -= nums[low];
            map.put(nums[low], map.get(nums[low]) - 1);

            if (map.get(nums[low]) == 0) {
                map.remove(nums[low]);
            }

            low++;
            high++;

            // Add new right element
            sum += nums[high];
            map.put(nums[high], map.getOrDefault(nums[high], 0) + 1);

            // Update answer only if all elements are distinct
            if (map.size() == k) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}