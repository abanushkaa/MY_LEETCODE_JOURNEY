class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;   // to store total subarrays
        long countZeros = 0;  // to count consecutive zeros

        for (int num : nums) {
            if (num == 0) {
                countZeros++;
                result += countZeros; 
                // each new zero extends all previous zero subarrays + itself
            } else {
                countZeros = 0; // reset when non-zero found
            }
        }

        return result;
    }
}