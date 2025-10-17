class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        Map<Long, Integer> mem = new HashMap<>();
        // dp(0, true, 0) returns number of additional partitions after processing all chars,
        // we add 1 because the last active prefix (the first partition) counts as well.
        return maxPartitionsAfterOperations(s, 0, true, 0, k, mem) + 1;
    }

    // i: current index
    // canChange: whether we still can change one character
    // mask: bitmask of letters in the current prefix
    private int maxPartitionsAfterOperations(final String s, int i, boolean canChange, int mask,
                                             int k, Map<Long, Integer> mem) {
        if (i == s.length()) return 0;

        long key = ((long)i << 27) | ((canChange ? 1L : 0L) << 26) | (mask & ((1<<26)-1));
        if (mem.containsKey(key)) return mem.get(key);

        // helper to process choosing a letter for s[i] (either original or changed to letter j)
        // nextCanChange is whether we still have the ability to change AFTER choosing this letter
        java.util.function.BiFunction<Integer, Boolean, Integer> getRes = (newBit, nextCanChange) -> {
            int newMask = mask | newBit;
            if (Integer.bitCount(newMask) > k) {
                // must cut here: count 1 partition, start new prefix at i+1 with mask = newBit
                return 1 + maxPartitionsAfterOperations(s, i + 1, nextCanChange, newBit, k, mem);
            } else {
                // can continue current prefix
                return maxPartitionsAfterOperations(s, i + 1, nextCanChange, newMask, k, mem);
            }
        };

        int res = 0;
        // Option 1: keep current character as is
        int origBit = 1 << (s.charAt(i) - 'a');
        res = Math.max(res, getRes.apply(origBit, canChange));

        // Option 2: if allowed, try changing current character to any of 26 letters
        if (canChange) {
            for (int j = 0; j < 26; j++) {
                int bit = 1 << j;
                // nextCanChange = false because we used the change at this position
                res = Math.max(res, getRes.apply(bit, false));
            }
        }

        mem.put(key, res);
        return res;
    }
}
