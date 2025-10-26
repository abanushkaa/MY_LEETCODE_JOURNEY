class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        // Step 1: Count frequencies of remainders
        for (int num : nums) {
            int rem = ((num % value) + value) % value;  // handle negative numbers
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }
//
        // Step 2: Find the smallest MEX we cannot form
        int mex = 0;
        while (true) {
            int rem = mex % value;
            if (freq.getOrDefault(rem, 0) > 0) {
                freq.put(rem, freq.get(rem) - 1);
                mex++;
            } else {
                return mex;
            }
        }
    }
}
