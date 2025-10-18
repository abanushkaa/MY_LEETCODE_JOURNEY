import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long current = Long.MIN_VALUE; // use long to avoid overflow for large nums[i]
        int count = 0;
        
        for (int num : nums) {
            long minPossible = num - k;
            long maxPossible = num + k;
            
            // choose the smallest possible distinct number > current
            long chosen = Math.max(current + 1, minPossible);
            
            if (chosen <= maxPossible) {
                count++;
                current = chosen; // update last used number
            }
        }
        
        return count;
    }
}
