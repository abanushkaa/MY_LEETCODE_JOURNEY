import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> damageMap = new HashMap<>();
        for (int p : power) {
            damageMap.put(p, damageMap.getOrDefault(p, 0L) + (long)p);
        }

        List<Integer> keys = new ArrayList<>(damageMap.keySet());
        Collections.sort(keys);

        int n = keys.size();
        if (n == 0) return 0;
        long[] dp = new long[n];
        dp[0] = damageMap.get(keys.get(0));

        for (int i = 1; i < n; i++) {
            long include = damageMap.get(keys.get(i));

            // We can only add dp[j] for keys[j] < keys[i] - 2
            // So find last index j with keys[j] <= keys[i] - 3
            int j = binarySearchLastLE(keys, i - 1, keys.get(i) - 3);
            if (j != -1) {
                include += dp[j];
            }

            dp[i] = Math.max(dp[i - 1], include);
        }

        return dp[n - 1];
    }

    // returns last index <= high that has keys[idx] <= target, or -1 if none
    private int binarySearchLastLE(List<Integer> keys, int high, int target) {
        int lo = 0, hi = high, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (keys.get(mid) <= target) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
