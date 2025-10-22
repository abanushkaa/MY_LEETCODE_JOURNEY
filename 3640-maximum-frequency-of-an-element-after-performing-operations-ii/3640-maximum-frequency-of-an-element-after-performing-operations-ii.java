import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        if (n == 0) return 0;

        // frequency of exact values
        HashMap<Long, Integer> freq = new HashMap<>();
        for (int v : nums) freq.put((long)v, freq.getOrDefault((long)v, 0) + 1);

        // sweep-line events: +1 at (v-k), -1 at (v+k+1)
        TreeMap<Long, Long> events = new TreeMap<>();
        for (int v : nums) {
            long left = (long)v - (long)k;
            long rightPlusOne = (long)v + (long)k + 1L;

            events.put(left, events.getOrDefault(left, 0L) + 1L);
            events.put(rightPlusOne, events.getOrDefault(rightPlusOne, 0L) - 1L);

            // ensure we will evaluate at v (so countEqual is available)
            if (!events.containsKey((long)v)) events.put((long)v, events.getOrDefault((long)v, 0L) + 0L);
        }

        int ans = 1;
        long currOverlap = 0L;

        // Iterate over events in sorted order. Overlap count is constant
        // on [key, nextKey - 1]. We evaluate at each key (and we ensured all nums values are keys).
        for (Map.Entry<Long, Long> entry : events.entrySet()) {
            long T = entry.getKey();
            currOverlap += entry.getValue();   // number of ranges covering integer T

            // how many elements are exactly T?
            int countEqual = freq.getOrDefault(T, 0);

            // totalInRange = currOverlap (number of nums that can be turned into T)
            int totalInRange = (int)Math.min(currOverlap, (long)n); // safe cast
            int convertible = totalInRange - countEqual; // those requiring one op each

            int possible = countEqual + Math.min(convertible, numOperations);
            if (possible > ans) ans = possible;
            if (ans == n) return n; // early exit: can't do better
        }

        return Math.min(ans, n);
    }
}
