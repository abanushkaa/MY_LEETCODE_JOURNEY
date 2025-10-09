class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] pref = new long[n];
        pref[0] = skill[0];
        for (int i = 1; i < n; i++) pref[i] = pref[i - 1] + skill[i];

        long s = 0L; // s[j] for current j (we keep only the running start)
        for (int j = 1; j < m; j++) {
            long best = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                long left = (long) mana[j - 1] * pref[i];
                long right = (i == 0) ? 0L : (long) mana[j] * pref[i - 1];
                long rhs = left - right;
                if (rhs > best) best = rhs;
            }
            s += best;
        }

        // Final finish time when last wizard finishes last potion
        return s + (long) mana[m - 1] * pref[n - 1];
    }
}
