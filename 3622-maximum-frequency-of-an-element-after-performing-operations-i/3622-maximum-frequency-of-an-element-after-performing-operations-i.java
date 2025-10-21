import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        if (n == 0) return 0;
        int minNum = Integer.MAX_VALUE, maxNum = Integer.MIN_VALUE;
        for (int v : nums) {
            minNum = Math.min(minNum, v);
            maxNum = Math.max(maxNum, v);
        }

        int low = minNum - k;    // inclusive
        int high = maxNum + k;   // inclusive

        int offset = -low;       // shift so indices are non-negative
        int size = high - low + 1;
        int[] cnt = new int[size];

        for (int v : nums) {
            cnt[v + offset]++;   // count occurrences
        }

        // build prefix sum
        int[] pref = new int[size];
        pref[0] = cnt[0];
        for (int i = 1; i < size; i++) pref[i] = pref[i - 1] + cnt[i];

        int ans = 1; // at least one element
        for (int T = low; T <= high; T++) {
            int tIdx = T + offset;
            int Lval = T - k;
            int Rval = T + k;
            int Lidx = Math.max(0, Lval + offset);
            int Ridx = Math.min(size - 1, Rval + offset);

            int totalInRange = pref[Ridx] - (Lidx > 0 ? pref[Lidx - 1] : 0);
            int count0 = (tIdx >= 0 && tIdx < size) ? cnt[tIdx] : 0;
            int count1 = totalInRange - count0;

            int possible = count0 + Math.min(numOperations, count1);
            if (possible > ans) ans = possible;
            if (ans == n) break; // early exit, can't do better than n
        }

        return Math.min(ans, n);
    }
}
