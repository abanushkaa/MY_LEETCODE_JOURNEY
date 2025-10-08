import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            
            // Minimum potion strength needed to reach or exceed success
            long minPotion = (success + spell - 1) / spell;  // equivalent to ceil(success / spell)
            
            // Find the index of the first potion >= minPotion
            int index = binarySearch(potions, minPotion);
            
            // Count = total potions - index
            result[i] = m - index;
        }

        return result;
    }

    // Custom binary search: find first index where potions[i] >= target
    private int binarySearch(int[] potions, long target) {
        int left = 0, right = potions.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
